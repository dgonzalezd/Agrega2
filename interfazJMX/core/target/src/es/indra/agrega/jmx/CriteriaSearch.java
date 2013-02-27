// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: HibernateSearch.vsl in andromda-spring-cartridge.
//
package es.indra.agrega.jmx;

import org.hibernate.criterion.Projection;
import org.hibernate.transform.ResultTransformer;

/**
 * Implements a generic search mechanism based on the Hibernate Criteria API. The
 * <code>CriteriaSearch</code> allows adding parameters which function as where clause. The
 * parameters are analysed whether they should be considered or not. This depends both on the actual
 * value of the parameter and on the configuration.<br>
 * The <code>CriteriaSearch</code> is expected to be a general solution for a basic search with
 * parameters connected by logical <b>and</b>. This search does <b>not</b> provide grouping.
 *
 * @author Stefan Reichert
 * @author Peter Friese
 * @author Chad Brandon
 * @see org.hibernate.Criteria
 * @see org.hibernate.criterion.Expression
 */
public class CriteriaSearch
{
    private CriteriaSearchConfiguration configuration;
    private org.hibernate.Criteria rootCriteria;
    private java.util.Map childCriteriaMap;
    private java.util.List orderList;
    private Class resultType;

    private static final class ParameterComparator
        implements java.util.Comparator
    {
        public int compare(final Object object1, final Object object2)
        {
            final CriteriaSearchParameter parameter1 = (CriteriaSearchParameter)object1;
            final CriteriaSearchParameter parameter2 = (CriteriaSearchParameter)object2;

            final int relevance1 = parameter1.getOrderRelevance();
            final int relevance2 = parameter2.getOrderRelevance();
            int result = 0;
            if (relevance1 > relevance2)
            {
                result = 1;
            }
            else if (relevance1 < relevance2)
            {
                result = -1;
            }
            return result;

        }
    }

    /**
     * Constructor for CriteriaSearch. Creates a <code>CriteriaSearch</code> with a default
     * <code>CriteriaSearchConfiguration</code>.
     *
     * @param session The Hibernate session.
     * @param resultType The <code>Class</code> of the result.
     */
    public CriteriaSearch(org.hibernate.Session session, Class resultType)
    {
        this.configuration = new CriteriaSearchConfiguration();
        this.resultType = resultType;
        this.rootCriteria = session.createCriteria(this.resultType);
        this.childCriteriaMap = new java.util.HashMap();
        this.orderList = new java.util.ArrayList();
    }

        /**
     * Executes a <code>HibernateQuery</code> using the currently defined
     * <code>CriteriaSearchParameter</code>s, and returns a java.util.List
     * containing the query results.
     *
     * @return result The result of the query.
     * @throws org.hibernate.HibernateException
     */
    public final java.util.List executeAsList()
        throws org.hibernate.HibernateException
    {

        // add ordering
        if (this.orderList.size() > 0)
        {
            java.util.Collections.sort(this.orderList, new ParameterComparator());
            for (java.util.Iterator orderIterator = this.orderList.iterator(); orderIterator.hasNext();)
            {
                CriteriaSearchParameter parameter = (CriteriaSearchParameter)orderIterator.next();            //parsing the pattern of the parameter
	            String[] path = CriteriaSearchParameter.PATTERN.split(parameter.getParameterPattern());
	            String parameterName = path[path.length - 1];
	            org.hibernate.Criteria parameterCriteria = this.rootCriteria;
	
	            org.hibernate.Criteria childEntityCriteria;
	            if (path.length > 1)
	            {
	                // We have a parameter affecting an attribute of an inner childEntity object so we need
	                // to traverse to get the right criteria object
	                childEntityCriteria = this.rootCriteria;
	                // Evaluating the proper criteria object for the defined parameter
	                Class type = this.resultType;
	                for (int index = 0; index < (path.length - 1); index++)
	                {
	                    final String childEntityName = path[index];
	                    final java.util.Collection embeddedValues = CriteriaSearchProperties.getEmbeddedValues(type);
	                    if (embeddedValues != null && embeddedValues.contains(childEntityName))
	                    {
	                        // - use the rest of the path as the parameter name
	                        final int number = path.length - index;
	                        final String[] restOfPath = new String[path.length - index];
	                        System.arraycopy(path, index, restOfPath, 0, number);
	                        parameterName = org.apache.commons.lang.StringUtils.join(restOfPath, ".");
	                        break;
	                    }
	                    type = CriteriaSearchProperties.getNavigableAssociationEndType(type, childEntityName);
	                    childEntityCriteria = locateCriteriaLeftJoin(
                                    childEntityName, childEntityCriteria);
	                }
	                if (childEntityCriteria != null)
	                {
	                    // We now have the right criteria object
	                    parameterCriteria = childEntityCriteria;
	                }
	            }

	            int direction = parameter.getOrderDirection();
	            if (direction == CriteriaSearchParameter.ORDER_ASC)
	            {
	            	parameterCriteria.addOrder(org.hibernate.criterion.Order.asc(parameterName));
	            }
	            else
	            {
	            	parameterCriteria.addOrder(org.hibernate.criterion.Order.desc(parameterName));
	            }
            }
        }

        // set the first result if configured
        if (this.configuration.getFirstResult() != null)
        {
            this.rootCriteria.setFirstResult(this.configuration.getFirstResult().intValue());
        }

        // set the fetch size if configured
        if (this.configuration.getFetchSize() != null)
        {
            this.rootCriteria.setFetchSize(this.configuration.getFetchSize().intValue());
        }

        // limit the maximum result if configured
        if (this.configuration.getMaximumResultSize() != null)
        {
            this.rootCriteria.setMaxResults(this.configuration.getMaximumResultSize().intValue());
        }
        
	// set the lockMode used for the consult
        if (this.configuration.getLockMode()!=null){
        	this.rootCriteria.setLockMode(this.configuration.getLockMode());
        }
        
        // Hibernate does not support a 'unique' identifier. As a search may contain outer joins,
        // duplicates in the resultList are possible. We eliminate any duplicates here, creating a
        // distinctified resultSet (Suggestion from Hibernate itself; see www.hibernate.org's FAQ's).
        final java.util.List result = this.rootCriteria.list();
        org.apache.commons.collections.CollectionUtils.filter(
            result,
            org.apache.commons.collections.functors.UniquePredicate.getInstance());
        return result;
    }
    
    /**
     * Executes a <code>HibernateQuery</code> using the currently defined
     * <code>CriteriaSearchParameter</code>s, and returns a java.util.Set
     * containing the query results.
     *
     * @return result The result of the query.
     * @throws org.hibernate.HibernateException
     */
    public java.util.Set executeAsSet() throws org.hibernate.HibernateException
    {
        return new java.util.LinkedHashSet(this.executeAsList());
    }

    /**
     * Adds a <code>CriteriaSearchParameter</code> to this search. The parameter is connected to
     * the search by logical <b>and</b>. It is not considered if the value is <code>null</code>.
     * If the value is not <code>null</code> it is compared using the
     * <code>CriteriaSearchParameter.EQUALS_COMPARATOR</code>.
     *
     * @param parameterValue The value of the parameter.
     * @param parameterPattern The pattern of the parameter (dot-seperated path e.g. person.address.street).
     * @throws org.hibernate.HibernateException
     */
    public void addParameter(Object parameterValue, String parameterPattern) throws org.hibernate.HibernateException
    {
        addParameter(new CriteriaSearchParameter(parameterValue, parameterPattern));
    }

    /**
     * Adds a <code>CriteriaSearchParameter</code> to this search. The parameter is connected to
     * the search by logical <b>and</b>. It is not considered if the value is <code>null</code> or
     * if the <code>String</code> empty. If the value is not <code>null</code> it is compared
     * using the <code>CriteriaSearchParameter.LIKE_COMPARATOR</code>.
     *
     * @param parameterValue The value of the parameter.
     * @param parameterPattern The pattern of the parameter (dot-seperated path e.g. person.address.street).
     * @throws org.hibernate.HibernateException
     */
    public void addParameter(String parameterValue, String parameterPattern) throws org.hibernate.HibernateException
    {
        addParameter(new CriteriaSearchParameter(parameterValue, parameterPattern));
    }

    /**
     * Adds a <code>CriteriaSearchParameter</code> to this search. The parameter is connected to
     * the search by logical <b>and</b>.
     *
     * @param parameter The <code>CriteriaSearchParameter</code> to add.
     * @throws org.hibernate.HibernateException
     */
    public void addParameter(CriteriaSearchParameter parameter) throws org.hibernate.HibernateException
    {
        if (considerParameter(parameter))
        {
            // parsing the pattern of the parameter
            String[] path = CriteriaSearchParameter.PATTERN.split(parameter.getParameterPattern());
            String parameterName = path[path.length - 1];
            org.hibernate.Criteria parameterCriteria = this.rootCriteria;

            org.hibernate.Criteria childEntityCriteria;
            if (path.length > 1)
            {
                // We have a parameter affecting an attribute of an inner childEntity object so we need
                // to traverse to get the right criteria object
                childEntityCriteria = this.rootCriteria;
                // Evaluating the proper criteria object for the defined parameter
                Class type = this.resultType;
                for (int index = 0; index < (path.length - 1); index++)
                {
                    final String childEntityName = path[index];
                    final java.util.Collection embeddedValues = CriteriaSearchProperties.getEmbeddedValues(type);
                    if (embeddedValues != null && embeddedValues.contains(childEntityName))
                    {
                        // - use the rest of the path as the parameter name
                        final int number = path.length - index;
                        final String[] restOfPath = new String[path.length - index];
                        System.arraycopy(path, index, restOfPath, 0, number);
                        parameterName = org.apache.commons.lang.StringUtils.join(restOfPath, ".");
                        break;
                    }
                                        type = CriteriaSearchProperties.getNavigableAssociationEndType(type, childEntityName);
                    if (parameter.isSearchIfIsNull()){
                    	childEntityCriteria = locateCriteriaLeftJoin(childEntityName, childEntityCriteria);
                    }else{
                    	childEntityCriteria = locateCriteria(childEntityName, childEntityCriteria);
                    }
                                    }
                if (childEntityCriteria != null)
                {
                    // We now have the right criteria object
                    parameterCriteria = childEntityCriteria;
                }
            }
            // check the type parameter value to add
            if(parameter.getParameterValue() instanceof Object[])
            {
                addExpression(
                    parameterCriteria,
                    parameterName,
                    (Object[])parameter.getParameterValue(),
                    parameter.getComparatorID(),
                    parameter.getMatchMode());
            }
            else
            {
                addExpression(
                    parameterCriteria,
                    parameterName,
                    parameter.getParameterValue(),
                    parameter.getComparatorID(),
                    parameter.getMatchMode());
            }
        }
        // if the parameter is to be ordered, add it to the order list
        if (parameter.getOrderDirection() != CriteriaSearchParameter.ORDER_UNSET)
        {
            this.orderList.add(parameter);
        }
    }

    /**
     * Decides whether a paramter is considered as a criteria for a search depending on the type and
     * value of the <code>parameterValue</code> and <code>searchIfIsNull</code>. A
     * <code>parameterValue</code> of the type <code>String</code> is considered
     * <code>null</code> if being a <code>NullPointer</code> or empty.
     *
     * @param parameter The parameter to check.
     */
    private boolean considerParameter(CriteriaSearchParameter parameter)
    {
        if (parameter.getParameterValue() instanceof String)
        {
            String stringParameterValue = (String) parameter.getParameterValue();
            return (parameter.isSearchIfIsNull()
                    || (stringParameterValue != null && stringParameterValue.length() > 0));
        }
        if (parameter.getParameterValue() instanceof Object[])
        {
            Object[] parameterValues = (Object[]) parameter.getParameterValue();
            return (parameter.isSearchIfIsNull()
                    || (parameterValues != null && parameterValues.length > 0));
        }
        return (parameter.isSearchIfIsNull() || (parameter.getParameterValue() != null));
    }

    /**
     * Adds an <code>Expression</code> to a <code>Criteria</code>.
     *
     * @param criteria
     * @param parameterName
     * @param parameterValue
     * @param comparatorID
     * @param matchMode
     */
    private void addExpression(
        org.hibernate.Criteria criteria,
        String parameterName,
        Object parameterValue,
        int comparatorID,
        org.hibernate.criterion.MatchMode matchMode)
    {
        if (parameterValue != null)
        {
            switch (comparatorID)
            {
                case CriteriaSearchParameter.LIKE_COMPARATOR:
                {
                    if ((matchMode != null) && (parameterValue instanceof String))
                    {
                        criteria.add(org.hibernate.criterion.Expression.like(
                            parameterName,
                            (String)parameterValue,
                            matchMode));
                    }
                    else
                    {
                        criteria.add(org.hibernate.criterion.Expression.like(parameterName, parameterValue));
                    }
                    break;
                }
                case CriteriaSearchParameter.INSENSITIVE_LIKE_COMPARATOR:
                {
                    if ((matchMode != null) && (parameterValue instanceof String))
                    {
                        criteria.add(org.hibernate.criterion.Expression.ilike(
                            parameterName,
                            (String)parameterValue,
                            matchMode));
                    }
                    else
                    {
                        criteria.add(org.hibernate.criterion.Expression.ilike(parameterName, parameterValue));
                    }
                    break;
                }
                case CriteriaSearchParameter.EQUAL_COMPARATOR:
                {
                    criteria.add(org.hibernate.criterion.Expression.eq(parameterName, parameterValue));
                    break;
                }
                case CriteriaSearchParameter.GREATER_THAN_OR_EQUAL_COMPARATOR:
                {
                    criteria.add(org.hibernate.criterion.Expression.ge(parameterName, parameterValue));
                    break;
                }
                case CriteriaSearchParameter.GREATER_THAN_COMPARATOR:
                {
                    criteria.add(org.hibernate.criterion.Expression.gt(parameterName, parameterValue));
                    break;
                }
                case CriteriaSearchParameter.LESS_THAN_OR_EQUAL_COMPARATOR:
                {
                    criteria.add(org.hibernate.criterion.Expression.le(parameterName, parameterValue));
                    break;
                }
                case CriteriaSearchParameter.LESS_THAN_COMPARATOR:
                {
                    criteria.add(org.hibernate.criterion.Expression.lt(parameterName, parameterValue));
                    break;
                }
            }
        }
        else
        {
            criteria.add(org.hibernate.criterion.Expression.isNull(parameterName));
        }

    }

    /**
     * Adds an <code>Expression</code> to a <code>Criteria</code>. The given <code>parameterValues</code>
     * represents either an array of <code>String</code> or another object. The different values in the
     * array are added to a disjunction which is connected with logical and to the other criteria of the
     * search.
     *
     * @param criteria
     * @param parameterName
     * @param parameterValues
     * @param searchIfNull
     * @param comparatorID
     * @param matchMode
     */
    private void addExpression(
        org.hibernate.Criteria criteria,
        String parameterName,
        Object[] parameterValues,
        int comparatorID,
        org.hibernate.criterion.MatchMode matchMode)
    {
        if (parameterValues != null)
        {
            org.hibernate.criterion.Disjunction disjunction =
                org.hibernate.criterion.Expression.disjunction();
            switch (comparatorID)
            {
                case CriteriaSearchParameter.LIKE_COMPARATOR:
                {
                    if ((matchMode != null) && (parameterValues instanceof String[]))
                    {
                        String[] stringParameterValues = (String[]) parameterValues;
                        for (int index = 0; index < parameterValues.length; index++) {
                            if (stringParameterValues[index] != null) {
                                disjunction.add(org.hibernate.criterion.Expression.like(
                                    parameterName, stringParameterValues[index], matchMode));
                            }
                            else {
                                disjunction.add(org.hibernate.criterion.Expression
                                    .isNull(parameterName));
                            }
                        }
                    }
                    else
                    {
                        for (int index = 0; index < parameterValues.length; index++) {
                            if (parameterValues[index] != null) {
                                disjunction.add(org.hibernate.criterion.Expression.like(
                                    parameterName, parameterValues[index]));
                            }
                            else {
                                disjunction.add(org.hibernate.criterion.Expression
                                        .isNull(parameterName));
                            }
                        }
                    }
                    break;
                }
                case CriteriaSearchParameter.INSENSITIVE_LIKE_COMPARATOR:
                {
                    if ((matchMode != null) && (parameterValues instanceof String[]))
                    {
                        String[] stringParameterValues = (String[]) parameterValues;
                        for (int index = 0; index < parameterValues.length; index++) {
                            if (stringParameterValues[index] != null) {
                                disjunction.add(org.hibernate.criterion.Expression.ilike(
                                    parameterName, stringParameterValues[index], matchMode));
                            }
                            else {
                                disjunction.add(org.hibernate.criterion.Expression
                                    .isNull(parameterName));
                            }
                        }
                    }
                    else
                    {
                        for (int index = 0; index < parameterValues.length; index++) {
                            if (parameterValues[index] != null) {
                                disjunction.add(org.hibernate.criterion.Expression.ilike(
                                    parameterName, parameterValues[index]));
                            }
                            else {
                                disjunction.add(org.hibernate.criterion.Expression
                                        .isNull(parameterName));
                            }
                        }
                    }
                    break;
                }
                case CriteriaSearchParameter.EQUAL_COMPARATOR:
                {
                    for (int index = 0; index < parameterValues.length; index++) {
                        if (parameterValues[index] != null) {
                            disjunction.add(org.hibernate.criterion.Expression.eq(parameterName,
                                    parameterValues[index]));
                        }
                        else {
                            disjunction.add(org.hibernate.criterion.Expression.isNull(parameterName));
                        }
                    }
                    break;
                }
                case CriteriaSearchParameter.GREATER_THAN_OR_EQUAL_COMPARATOR:
                {
                    for (int index = 0; index < parameterValues.length; index++) {
                        if (parameterValues[index] != null) {
                            disjunction.add(org.hibernate.criterion.Expression.ge(parameterName,
                                    parameterValues[index]));
                        }
                        else {
                            disjunction.add(org.hibernate.criterion.Expression.isNull(parameterName));
                        }
                    }
                    break;
                }
                case CriteriaSearchParameter.GREATER_THAN_COMPARATOR:
                {
                    for (int index = 0; index < parameterValues.length; index++) {
                        if (parameterValues[index] != null) {
                            disjunction.add(org.hibernate.criterion.Expression.gt(parameterName,
                                    parameterValues[index]));
                        }
                        else {
                            disjunction.add(org.hibernate.criterion.Expression.isNull(parameterName));
                        }
                    }
                    break;
                }
                case CriteriaSearchParameter.LESS_THAN_OR_EQUAL_COMPARATOR:
                {
                    for (int index = 0; index < parameterValues.length; index++) {
                        if (parameterValues[index] != null) {
                            disjunction.add(org.hibernate.criterion.Expression.le(parameterName,
                                    parameterValues[index]));
                        }
                        else {
                            disjunction.add(org.hibernate.criterion.Expression.isNull(parameterName));
                        }
                    }
                    break;
                }
                case CriteriaSearchParameter.LESS_THAN_COMPARATOR:
                {
                    for (int index = 0; index < parameterValues.length; index++) {
                        if (parameterValues[index] != null) {
                            disjunction.add(org.hibernate.criterion.Expression.lt(parameterName,
                                    parameterValues[index]));
                        }
                        else {
                            disjunction.add(org.hibernate.criterion.Expression.isNull(parameterName));
                        }
                    }
                    break;
                }
            }
            criteria.add(disjunction);
        }
        else
        {
            criteria.add(org.hibernate.criterion.Expression.isNull(parameterName));
        }
    }

    /**
     * Locates a <code>Criteria</code> for a <code>childEntityName</code>. If a
     * <code>Criteria</code> exists for the <code>childEntityName</code>, it is returned. If
     * not, one is created and referenced in the <code>childCriteriaMap</code> under the
     * <code>childEntityName</code>.
     *
     * @param childEntityName
     * @param parentCriteria
     * @return criteria The Criteria for the childEntityName.
     * @throws org.hibernate.HibernateException
     */
    private org.hibernate.Criteria locateCriteria(String childEntityName, org.hibernate.Criteria parentCriteria) throws org.hibernate.HibernateException
    {
        if (this.childCriteriaMap.containsKey(childEntityName))
        {
            return (org.hibernate.Criteria) this.childCriteriaMap.get(childEntityName);
        }
        org.hibernate.Criteria childCriteria = parentCriteria.createCriteria(childEntityName);
        if (this.configuration.isForceEagerLoading())
        {
            parentCriteria.setFetchMode(childEntityName, org.hibernate.FetchMode.JOIN);
        }
        this.childCriteriaMap.put(childEntityName, childCriteria);
        return childCriteria;
    }

	    /**
     * Locates a <code>Criteria</code> for a <code>childEntityName</code>. If a
     * <code>Criteria</code> exists for the <code>childEntityName</code>, it is returned. If
     * not, one is created and referenced in the <code>childCriteriaMap</code> under the
     * <code>childEntityName</code>.
     *
     * @param childEntityName
     * @param parentCriteria
     * @return criteria The Criteria for the childEntityName.
     * @throws org.hibernate.HibernateException
     */
    private org.hibernate.Criteria locateCriteriaLeftJoin(String childEntityName, org.hibernate.Criteria parentCriteria) throws org.hibernate.HibernateException
    {
        if (this.childCriteriaMap.containsKey(childEntityName))
        {
            return (org.hibernate.Criteria) this.childCriteriaMap.get(childEntityName);
        }
        org.hibernate.Criteria childCriteria = 
        	parentCriteria.createCriteria(
                childEntityName,
                org.hibernate.sql.JoinFragment.LEFT_OUTER_JOIN);
        this.childCriteriaMap.put(childEntityName, childCriteria);
        return childCriteria;
    }
    
    /**
     * Returns the configuration of this search.
     *
     * @return configuration
     */
    public CriteriaSearchConfiguration getConfiguration()
    {
        return this.configuration;
    }

    /**
     * Sets the Projections object to the rootCriteria
     *
     * @param projection The Projection object to set.           
     */  
    public void setProjection(Projection projection)
    {
        this.rootCriteria.setProjection(projection);
    }
    
    /**
     * Sets the ResultTransformer object to the rootCriteria
     *
     * @param resultTransformer The ResultTransformer object to set.           
     */  
    public void setResultTransformer(ResultTransformer resultTransformer)
    {
        this.rootCriteria.setResultTransformer(resultTransformer);
    }
    
}