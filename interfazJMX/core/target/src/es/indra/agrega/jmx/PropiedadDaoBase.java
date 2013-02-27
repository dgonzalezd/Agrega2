// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: SpringHibernateDaoBase.vsl in andromda-spring-cartridge.
//
package es.indra.agrega.jmx;

import net.sf.dozer.util.mapping.MapperIF;

/**
 * <p>
 * Base Spring DAO Class: is able to create, update, remove, load, and find
 * objects of type <code>es.indra.agrega.jmx.Propiedad</code>.
 * </p>
 *
 * @see es.indra.agrega.jmx.Propiedad
 */
public abstract class PropiedadDaoBase
    extends org.springframework.orm.hibernate3.support.HibernateDaoSupport
    implements es.indra.agrega.jmx.PropiedadDao
{



	

	/**
	 * Constant that identifies a mapping between an 
	 * entity (Propiedad) and a VO (PropiedadVO)
	 */
	public final static String DEF_MAPPING_PROPIEDAD_PROPIEDADVO = "DEF_MAPPING_PROPIEDAD_PROPIEDADVO";
	
	/**
	 * Constant that identifies a mapping between a 
	 * VO (PropiedadVO) and an entity (Propiedad)
	 */
	public final static String DEF_MAPPING_PROPIEDADVO_PROPIEDAD = "DEF_MAPPING_PROPIEDADVO_PROPIEDAD";
	
	/**
	 * Reference to the dozer bean mapper used in the application (singleton).
	 */
	private MapperIF beanMapper;
	
	/**
	 * Gets the reference to the dozer bean mapper used in the application (singleton).
	 * @return MapperIF
	 */
    protected MapperIF getBeanMapper() {
		return beanMapper;
	}

    /**
     * Sets the instance of the Dozer bean mapper to be used.
     * @param beanMapper
     */
	public void setBeanMapper(MapperIF beanMapper) {
		this.beanMapper = beanMapper;
	}


    /**
     * @see es.indra.agrega.jmx.PropiedadDao#load(int, java.lang.String)
     */
    public Object load(final int transform, final java.lang.String Nombre)
    {
        if (Nombre == null)
        {
            throw new IllegalArgumentException(
                "Propiedad.load - 'Nombre' can not be null");
        }
        final java.util.List list = this.getHibernateTemplate().find(
            "from es.indra.agrega.jmx.Propiedad as entity where entity.Nombre = ?", Nombre);
        final Object entity = list != null && !list.isEmpty() ? list.iterator().next() : null;
        return transformEntity(transform, (es.indra.agrega.jmx.Propiedad)entity);
    }

    /**
     * @see es.indra.agrega.jmx.PropiedadDao#load(java.lang.String)
     */
    public es.indra.agrega.jmx.Propiedad load(java.lang.String Nombre)
    {
        return (es.indra.agrega.jmx.Propiedad)this.load(TRANSFORM_NONE, Nombre);
    }
    
    /**
     * @see es.indra.agrega.jmx.PropiedadDao#loadAll()
     */
    public java.util.Collection loadAll()
    {
        return this.loadAll(TRANSFORM_NONE);
    }
    
    /**
     * @see es.indra.agrega.jmx.PropiedadDao#loadAll(int)
     */
    public java.util.Collection loadAll(final int transform)
    {
        final java.util.Collection results = this.getHibernateTemplate().loadAll(es.indra.agrega.jmx.PropiedadImpl.class);
        this.transformEntities(transform, results);
        return results;
    }
    

    /**
     * @see es.indra.agrega.jmx.PropiedadDao#create(es.indra.agrega.jmx.Propiedad)
     */
    public es.indra.agrega.jmx.Propiedad create(es.indra.agrega.jmx.Propiedad propiedad)
    {
        return (es.indra.agrega.jmx.Propiedad)this.create(TRANSFORM_NONE, propiedad);
    }

    /**
     * @see es.indra.agrega.jmx.PropiedadDao#create(int transform, es.indra.agrega.jmx.Propiedad)
     */
    public Object create(final int transform, final es.indra.agrega.jmx.Propiedad propiedad)
    {
        if (propiedad == null)
        {
            throw new IllegalArgumentException(
                "Propiedad.create - 'propiedad' can not be null");
        }
        Object identifier = this.getHibernateTemplate().save(propiedad);
        propiedad.setNombre((java.lang.String)identifier);
        return this.transformEntity(transform, propiedad);
    }

    /**
     * @see es.indra.agrega.jmx.PropiedadDao#create(java.util.Collection)
     */
    public java.util.Collection create(final java.util.Collection entities)
    {
        return create(TRANSFORM_NONE, entities);
    }

    /**
     * @see es.indra.agrega.jmx.PropiedadDao#create(int, java.util.Collection)
     */
    public java.util.Collection create(final int transform, final java.util.Collection entities)
    {
        if (entities == null)
        {
            throw new IllegalArgumentException(
                "Propiedad.create - 'entities' can not be null");
        }
        this.getHibernateTemplate().execute(
            new org.springframework.orm.hibernate3.HibernateCallback()
            {
                public Object doInHibernate(org.hibernate.Session session)
                    throws org.hibernate.HibernateException
                {
                    for (java.util.Iterator entityIterator = entities.iterator(); entityIterator.hasNext();)
                    {
                        create(transform, (es.indra.agrega.jmx.Propiedad)entityIterator.next());
                    }
                    return null;
                }
            },
            true);
        return entities;
    }

    /**
     * @see es.indra.agrega.jmx.PropiedadDao#create(int, java.lang.String,java.lang.String,java.lang.String)
     */
    public es.indra.agrega.jmx.Propiedad create(
 java.lang.String Valor, java.lang.String Descripcion, java.lang.String Ejemplo)
    {
         return (es.indra.agrega.jmx.Propiedad)this.create(TRANSFORM_NONE,  Valor, Descripcion, Ejemplo);
    }

    /**
     * @see es.indra.agrega.jmx.PropiedadDao#create(int, java.lang.String,java.lang.String,java.lang.String)
     */
    public Object create(
        final int transform,
 java.lang.String Valor, java.lang.String Descripcion, java.lang.String Ejemplo)
    {
        es.indra.agrega.jmx.Propiedad entity = new es.indra.agrega.jmx.PropiedadImpl();
        entity.setValor(Valor);
        entity.setDescripcion(Descripcion);
        entity.setEjemplo(Ejemplo);
        return this.create(transform, entity);
    }

    /**
     * @see es.indra.agrega.jmx.PropiedadDao#update(es.indra.agrega.jmx.Propiedad)
     */
    public void update(es.indra.agrega.jmx.Propiedad propiedad)
    {
        if (propiedad == null)
        {
            throw new IllegalArgumentException(
                "Propiedad.update - 'propiedad' can not be null");
        }
        this.getHibernateTemplate().update(propiedad);
    }

    /**
     * @see es.indra.agrega.jmx.PropiedadDao#update(java.util.Collection)
     */
    public void update(final java.util.Collection entities)
    {
        if (entities == null)
        {
            throw new IllegalArgumentException(
                "Propiedad.update - 'entities' can not be null");
        }
        this.getHibernateTemplate().execute(
            new org.springframework.orm.hibernate3.HibernateCallback()
            {
                public Object doInHibernate(org.hibernate.Session session)
                    throws org.hibernate.HibernateException
                {
                    for (java.util.Iterator entityIterator = entities.iterator(); entityIterator.hasNext();)
                    {
                        update((es.indra.agrega.jmx.Propiedad)entityIterator.next());
                    }
                    return null;
                }
            },
            true);
    }

    /**
     * @see es.indra.agrega.jmx.PropiedadDao#remove(es.indra.agrega.jmx.Propiedad)
     */
    public void remove(es.indra.agrega.jmx.Propiedad propiedad)
    {
        if (propiedad == null)
        {
            throw new IllegalArgumentException(
                "Propiedad.remove - 'propiedad' can not be null");
        }
        this.getHibernateTemplate().delete(propiedad);
    }

    /**
     * @see es.indra.agrega.jmx.PropiedadDao#remove(java.lang.String)
     */
    public void remove(java.lang.String Nombre)
    {
        if (Nombre == null)
        {
            throw new IllegalArgumentException(
                "Propiedad.remove - 'Nombre' can not be null");
        }
        es.indra.agrega.jmx.Propiedad entity = this.load(Nombre);
        if (entity != null)
        {
            this.remove(entity);
        }
    }

    /**
     * @see es.indra.agrega.jmx.PropiedadDao#remove(java.util.Collection)
     */
    public void remove(java.util.Collection entities)
    {
        if (entities == null)
        {
            throw new IllegalArgumentException(
                "Propiedad.remove - 'entities' can not be null");
        }
        this.getHibernateTemplate().deleteAll(entities);
    }

    /**
     * Allows transformation of entities into value objects
     * (or something else for that matter), when the <code>transform</code>
     * flag is set to one of the constants defined in <code>es.indra.agrega.jmx.PropiedadDao</code>, please note
     * that the {@link #TRANSFORM_NONE} constant denotes no transformation, so the entity itself
     * will be returned.
     * <p/>
     * This method will return instances of these types:
     * <ul>
     *   <li>{@link es.indra.agrega.jmx.Propiedad} - {@link #TRANSFORM_NONE}</li>
     *   <li>{@link es.indra.agrega.jmx.PropiedadVO} - {@link TRANSFORM_PROPIEDADVO}</li>
     * </ul>
     *
     * If the integer argument value is unknown {@link #TRANSFORM_NONE} is assumed.
     *
     * @param transform one of the constants declared in {@link es.indra.agrega.jmx.PropiedadDao}
     * @param entity an entity that was found
     * @return the transformed entity (i.e. new value object, etc)
     * @see #transformEntities(int,java.util.Collection)
     */
    private final Object transformEntity(final int transform, final es.indra.agrega.jmx.Propiedad entity)
    {
        Object target = null;
        if (entity != null)
        {
            switch (transform)
            {
                case es.indra.agrega.jmx.PropiedadDao.TRANSFORM_PROPIEDADVO :
                    target = toPropiedadVO(entity);
                    break;
                case TRANSFORM_NONE : // fall-through
                default:
                    target = entity;
            }
        }
        return target;
    }

    /**
     * Transforms a collection of entities using the
     * {@link #transformEntity(int,es.indra.agrega.jmx.Propiedad)}
     * method. This method does not instantiate a new collection.
     * <p/>
     * This method is to be used internally only.
     *
     * @param transform one of the constants declared in <code>es.indra.agrega.jmx.PropiedadDao</code>
     * @param entities the collection of entities to transform
     * @return the same collection as the argument, but this time containing the transformed entities
     * @see #transformEntity(int,es.indra.agrega.jmx.Propiedad)
     */
    private final void transformEntities(final int transform, final java.util.Collection entities)
    {
        switch (transform)
        {
            case es.indra.agrega.jmx.PropiedadDao.TRANSFORM_PROPIEDADVO :
                toPropiedadVOCollection(entities);
                break;
            case TRANSFORM_NONE : // fall-through
                default:
                // do nothing;
        }
    }

    /**
     * @see es.indra.agrega.jmx.PropiedadDao#toPropiedadVOCollection(java.util.Collection)
     */
    public final void toPropiedadVOCollection(java.util.Collection entities)
    {
        if (entities == null)
        {
            entities = java.util.Collections.EMPTY_LIST;
        }
        else
        {
            org.apache.commons.collections.CollectionUtils.transform(entities, PROPIEDADVO_TRANSFORMER);
        }
    }

    /**
     * Base implementation for transforming the results of a report query into a value object. This
     * implementation exists for convenience reasons only. It needs only be overridden in the
     * {@link PropiedadDaoImpl} class if you intend to use reporting queries.
     * @see es.indra.agrega.jmx.PropiedadDao#toPropiedadVO(es.indra.agrega.jmx.Propiedad)
     */
    protected es.indra.agrega.jmx.PropiedadVO toPropiedadVO(Object[] row)
    {
        return null;
    }

    /**
     * This anonymous transformer is designed to transform entities or report query results
     * (which result in an array of objects) to {@link es.indra.agrega.jmx.PropiedadVO}
     * using the Jakarta Commons-Collections Transformation API.
     */
    private final org.apache.commons.collections.Transformer PROPIEDADVO_TRANSFORMER =
        new org.apache.commons.collections.Transformer()
        {
            public Object transform(Object input)
            {
                Object result = null;
                if (input instanceof es.indra.agrega.jmx.Propiedad)
                {
                    result = toPropiedadVO((es.indra.agrega.jmx.Propiedad)input);
                }
                else if (input instanceof Object[])
                {
                    result = toPropiedadVO((Object[])input);
                }
                return result;
            }
        };

	/**
	 * Copy a VO to a new entity using the default Dozer mappings.
	 * @param vo The source bean (VO)
	 * @return A new entity created with the values extracted from the vo.
	 */
	public es.indra.agrega.jmx.Propiedad fromPropiedadVO(final es.indra.agrega.jmx.PropiedadVO vo) {
        //default mapping between VO and entity
        return (es.indra.agrega.jmx.Propiedad) 
                  this.getBeanMapper().map(vo, es.indra.agrega.jmx.PropiedadImpl.class, DEF_MAPPING_PROPIEDADVO_PROPIEDAD);
    }

	/**
	 * Copy a VO to an existing entity using the default Dozer mappings.
	 * @param vo The source bean (VO)
	 * @param entity The destination bean (an existing entity)
	 */
    public void fromPropiedadVO(es.indra.agrega.jmx.PropiedadVO vo, es.indra.agrega.jmx.Propiedad entity) {
        //default mapping between VO and entity
        this.getBeanMapper().map(vo, entity, DEF_MAPPING_PROPIEDADVO_PROPIEDAD);
    }
		
		
}