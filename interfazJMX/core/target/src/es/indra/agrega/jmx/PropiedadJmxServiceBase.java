// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: SpringServiceBase.vsl in andromda-spring-cartridge.
//
package es.indra.agrega.jmx;

import net.sf.dozer.util.mapping.MapperIF;

import org.apache.log4j.Logger;


/**
 * <p>
 * Spring Service base class for <code>es.indra.agrega.jmx.PropiedadJmxService</code>,
 * provides access to all services and entities referenced by this service.
 * </p>
 *
 * @see es.indra.agrega.jmx.PropiedadJmxService
 */
public abstract class PropiedadJmxServiceBase
    implements es.indra.agrega.jmx.PropiedadJmxService
{

		 protected static final Logger logger = Logger.getLogger(PropiedadJmxServiceBase.class);


	
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


    private es.indra.agrega.jmx.PropiedadDao propiedadDao;

    /**
     * Sets the reference to <code>propiedad</code>'s DAO.
     */
    public void setPropiedadDao(es.indra.agrega.jmx.PropiedadDao propiedadDao)
    {
        this.propiedadDao = propiedadDao;
    }

    /**
     * Gets the reference to <code>propiedad</code>'s DAO.
     */
    protected es.indra.agrega.jmx.PropiedadDao getPropiedadDao()
    {
        return this.propiedadDao;
    }


    /**
     * Gets the current <code>principal</code> if one has been set,
     * otherwise returns <code>null</code>.
     *
     * @return the current principal
     */
    protected java.security.Principal getPrincipal()
    {
        return es.indra.agrega.jmx.PrincipalStore.get();
    }
}