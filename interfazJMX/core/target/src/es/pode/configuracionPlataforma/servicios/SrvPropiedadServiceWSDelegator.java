// license-header java merge-point
package es.pode.configuracionPlataforma.servicios;

/**
 * Web service delegator for {@link es.pode.configuracionPlataforma.servicios.SrvPropiedadService}.
 *
 * @see es.pode.configuracionPlataforma.servicios.SrvPropiedadService
 */
public class SrvPropiedadServiceWSDelegator
{

    /**
     * Gets an instance of {@link es.pode.configuracionPlataforma.servicios.SrvPropiedadService}
     */
    private final es.pode.configuracionPlataforma.servicios.SrvPropiedadService getSrvPropiedadService()
    {
        return es.indra.agrega.jmx.ServiceLocator.instance().getSrvPropiedadService();
    }

    /**
     * @see es.pode.configuracionPlataforma.servicios.SrvPropiedadService#getAllProperties()
     */
    public java.util.List getAllProperties()
    {
        return getSrvPropiedadService().getAllProperties();
    }

    /**
     * @see es.pode.configuracionPlataforma.servicios.SrvPropiedadService#getPropiedad(java.lang.String)
     */
    public es.indra.agrega.jmx.PropiedadVO getPropiedad(java.lang.String Nombre)
    {
        return getSrvPropiedadService().getPropiedad(Nombre);
    }

    /**
     * @see es.pode.configuracionPlataforma.servicios.SrvPropiedadService#updatePropiedad(es.indra.agrega.jmx.Propiedad)
     */
    public void updatePropiedad(es.indra.agrega.jmx.Propiedad Propiedad)
    {
        getSrvPropiedadService().updatePropiedad(Propiedad);
    }

    /**
     * @see es.pode.configuracionPlataforma.servicios.SrvPropiedadService#get(java.lang.String)
     */
    public java.lang.String get(java.lang.String property)
    {
        return getSrvPropiedadService().get(property);
    }

    /**
     * @see es.pode.configuracionPlataforma.servicios.SrvPropiedadService#set(java.lang.String, java.lang.String)
     */
    public boolean set(java.lang.String nombre, java.lang.String valor)
    {
        return getSrvPropiedadService().set(nombre, valor);
    }

    /**
     * @see es.pode.configuracionPlataforma.servicios.SrvPropiedadService#getUrlNodo()
     */
    public java.lang.String getUrlNodo()
    {
        return getSrvPropiedadService().getUrlNodo();
    }

}