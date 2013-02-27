// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.indra.agrega.jmx;


/**
 * @see es.indra.agrega.jmx.PropiedadJmxService
 */
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import org.apache.commons.io.IOUtils;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;

import es.pode.soporte.utiles.ficheros.UtilesFicheros;





/**
 *  Anotacion que se usa para marcar la clase como un Mbean                                                                                   
 */

@ManagedResource(objectName="agrega:name=propiedadJmxService", description="Configuracion de Agrega2", log=true,
		logFile="jmx.log", currencyTimeLimit=15, persistPolicy="OnUpdate", persistPeriod=200)
public class PropiedadJmxServiceImpl
    extends es.indra.agrega.jmx.PropiedadJmxServiceBase /*implements NotificationPublisherAware*/
{

	private static String ENCODING ="Cp1252";
//	private static String ENCODING ="UTF-8";
	private static String OK="OK";
//	String casUrl,ldapManagerdn;	  
//	  private NotificationPublisher publisher;
	
	  private String getPropiedad(Propiedades propiedad) {
			if(propiedad.getValor()==null||propiedad.getValor().equals("")) {
				logger.debug("Leo "+propiedad.getNombreConPrefijo()+" de BBDD");
				PropiedadVO propiedadVO=(PropiedadVO)this.getPropiedadDao().load(PropiedadDao.TRANSFORM_PROPIEDADVO,propiedad.getNombreConPrefijo());
				propiedad.setValor(propiedadVO.getValor());
				logger.debug("Obtengo "+propiedadVO.getValor());
			}
			return propiedad.getValor();
		}
		
		private void setPropiedad(String valor, Propiedades propiedad) {
//			String nombre = propiedad.getNombre();
//			logger.debug("Nombre de propiedad es "+nombre);
			try {
		        Propiedad propiedadEntity=this.getPropiedadDao().load(propiedad.getNombreConPrefijo());       
		        propiedadEntity.setValor(valor);	        
		        this.getPropiedadDao().update(propiedadEntity);
				
				
				propiedad.setValor(valor);
				String[] mensajes=rellenaPropiedad(new PropiedadVO(propiedad.getNombre(), valor, "", ""));
				logger.debug("Resultados de rellenado de propiedad "+propiedad.getNombre());
				for (int i = 0; i < mensajes.length; i++) {
					logger.debug(mensajes[i]);
				}
			} catch (Exception e) {
				logger.error("Error rellenando variable "+propiedad.getNombre()+" con "+valor+": "+e.getMessage());
			}
		}
	  
	
/** 
 * Este metodo permite marcar la propiedad CasUrl, como de escritura gracias a la anotacion "ManagedAttribute"                                
 */
	  
	   @ManagedAttribute(description="Atributo casUrl")
	   public void setCasUrl(String valor) {
		   Propiedades propiedad=Propiedades.casurl;
		   setPropiedad(valor, propiedad);
	   }

	    
/**
 * Este metodo permite marcar la propiedad CasUrl, como de lectura gracias a la anotacion "ManagedAttribute"                                  
 */
	    
	    @ManagedAttribute(description="Atributo casUrl")
	    public String getCasUrl() {
	    	Propiedades propiedad = Propiedades.casurl;
	    	String valor= getPropiedad(propiedad);
	    	return valor;
	    }

/**	 
 * Este metodo permite marcar la propiedad setLdapManagerdn, como de escritura gracias a la anotacion "ManagedAttribute"                      
 */

	    @ManagedAttribute(description="Atributo ldapManagerdn")
	    public void setLdapManagerdn(String valor) {
	       	Propiedades propiedad=Propiedades.ldapmanagerDN;
	    	setPropiedad(valor, propiedad);
	    }

/** 
 * Este metodo permite marcar la propiedad setLdapManagerdn, como de lectura gracias a la anotacion "ManagedAttribute"                        
 */
   
	    
	    @ManagedAttribute(description="Atributo ldapManagerdn")
	    public String getLdapManagerdn() {	
	    	Propiedades propiedad = Propiedades.ldapmanagerDN;
	    	String valor= getPropiedad(propiedad);
	    	return valor;
	    }
 

	    /**	 
	     * Este metodo permite marcar la propiedad setLdapManagerdn, como de escritura gracias a la anotacion "ManagedAttribute"                      
	     */

	    @ManagedAttribute(description="Atributo neutro")
	    public void setNeutro(String valor) {
	    	Propiedades propiedad=Propiedades.neutro;
	    	setPropiedad(valor, propiedad);
	    }

	    /** 
	     * Este metodo permite marcar la propiedad setLdapManagerdn, como de lectura gracias a la anotacion "ManagedAttribute"                        
	     */


	    @ManagedAttribute(description="Atributo neutro")
	    public String getNeutro() {	
	    	Propiedades propiedad = Propiedades.neutro;
	    	String valor= getPropiedad(propiedad);
	    	return valor;
	    }
	    
	    
//	    @ManagedAttribute(description="Atributo galeriaImgPath")
//	    public void setGaleriaImgPath(String valor) {
//	    	Propiedades propiedad=Propiedades.galeriaImgPath;
//	    	setPropiedad(valor, propiedad);
//	    }
//	    
//	    @ManagedAttribute(description="Atributo galeriaImgPath")
//	    public String getGaleriaImgPath() {
//	    	Propiedades propiedad = Propiedades.galeriaImgPath;
//	    	return getPropiedad(propiedad);
//	    }

	    @ManagedAttribute(description="Atributo nodo.jboss")
	    public void setNodoJBoss(String valor) {
	    	Propiedades propiedad=Propiedades.nodo_jboss;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo nodo.jboss")
	    public String getNodoJBoss() {
	    	Propiedades propiedad = Propiedades.nodo_jboss;
	    	return getPropiedad(propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo nodo")
	    public void setNodo(String valor) {
	    	Propiedades propiedad=Propiedades.nodo;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo nodo")
	    public String getNodo() {
	    	Propiedades propiedad = Propiedades.nodo;
	    	return getPropiedad(propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo path_logs")
	    public void setPath_Logs(String valor) {
	    	Propiedades propiedad=Propiedades.path_logs;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo path_logs")
	    public String getPath_Logs() {
	    	Propiedades propiedad = Propiedades.path_logs;
	    	return getPropiedad(propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo puerto")
	    public void setPuerto(String valor) {
	    	Propiedades propiedad=Propiedades.puerto;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo puerto")
	    public String getPuerto() {
	    	Propiedades propiedad = Propiedades.puerto;
	    	return getPropiedad(propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo port.jboss")
	    public void setPuertoJBoss(String valor) {
	    	Propiedades propiedad=Propiedades.puerto_jboss;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo port.jboss")
	    public String getPuertoJBoss() {
	    	Propiedades propiedad = Propiedades.puerto_jboss;
	    	return getPropiedad(propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo subdominio_jboss")
	    public void setSubdominio_Jboss(String valor) {
	    	Propiedades propiedad=Propiedades.subdominio_jboss;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo subdominio_jboss")
	    public String getSubdominio_Jboss() {
	    	Propiedades propiedad = Propiedades.subdominio_jboss;
	    	return getPropiedad(propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo auditoria")
	    public void setAuditoria(String valor) {
	    	Propiedades propiedad=Propiedades.auditoria;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo auditoria")
	    public String getAuditoria() {
	    	Propiedades propiedad = Propiedades.auditoria;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo birtDir")
	    public void setBirtDir(String valor) {
	    	Propiedades propiedad=Propiedades.birtDir;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo birtDir")
	    public String getBirtDir() {
	    	Propiedades propiedad = Propiedades.birtDir;
	    	return getPropiedad(propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo destinoInformesCarga")
	    public void setDestinoInformesCarga(String valor) {
	    	Propiedades propiedad=Propiedades.destinoInformesCarga;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo destinoInformesCarga")
	    public String getDestinoInformesCarga() {
	    	Propiedades propiedad = Propiedades.destinoInformesCarga;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo destinoInformesDir")
	    public void setDestinoInformesDir(String valor) {
	    	Propiedades propiedad=Propiedades.destinoInformesDir;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo destinoInformesDir")
	    public String getDestinoInformesDir() {
	    	Propiedades propiedad = Propiedades.destinoInformesDir;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo destinoInformesFederadosDir")
	    public void setDestinoInformesFederadosDir(String valor) {
	    	Propiedades propiedad=Propiedades.destinoInformesFederadosDir;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo destinoInformesFederadosDir")
	    public String getDestinoInformesFederadosDir() {
	    	Propiedades propiedad = Propiedades.destinoInformesFederadosDir;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo destinoInformesMasDir")
	    public void setDestinoInformesMasDir(String valor) {
	    	Propiedades propiedad=Propiedades.destinoInformesMasDir;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo destinoInformesMasDir")
	    public String getDestinoInformesMasDir() {
	    	Propiedades propiedad = Propiedades.destinoInformesMasDir;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo dias")
	    public void setDias(String valor) {
	    	Propiedades propiedad=Propiedades.dias;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo dias")
	    public String getDias() {
	    	Propiedades propiedad = Propiedades.dias;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo diasAnterioresInformesPortada")
	    public void setDiasAnterioresInformesPortada(String valor) {
	    	Propiedades propiedad=Propiedades.diasAnterioresInformesPortada;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo diasAnterioresInformesPortada")
	    public String getDiasAnterioresInformesPortada() {
	    	Propiedades propiedad = Propiedades.diasAnterioresInformesPortada;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo esquemaDeMetadatos")
	    public void setEsquemaDeMetadatos(String valor) {
	    	Propiedades propiedad=Propiedades.esquemaDeMetadatos;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo esquemaDeMetadatos")
	    public String getEsquemaDeMetadatos() {
	    	Propiedades propiedad = Propiedades.esquemaDeMetadatos;
	    	return getPropiedad(propiedad);
	    }

	    @ManagedAttribute(description="Atributo feed_default")
	    public void setFeed_default(String valor) {
	    	Propiedades propiedad=Propiedades.feed_default;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo feed_default")
	    public String getFeed_default() {
	    	Propiedades propiedad = Propiedades.feed_default;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo galeriaimg_common_image")
	    public void setGaleriaimg_common_image(String valor) {
	    	Propiedades propiedad=Propiedades.galeriaimg_common_image;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo galeriaimg_common_image")
	    public String getGaleriaimg_common_image() {
	    	Propiedades propiedad = Propiedades.galeriaimg_common_image;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo galeriaimg_image_common_path")
	    public void setGaleriaimg_image_common_path(String valor) {
	    	Propiedades propiedad=Propiedades.galeriaimg_image_common_path;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo galeriaimg_image_common_path")
	    public String getGaleriaimg_image_common_path() {
	    	Propiedades propiedad = Propiedades.galeriaimg_image_common_path;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo galeriaimg_image_ext")
	    public void setGaleriaimg_image_ext(String valor) {
	    	Propiedades propiedad=Propiedades.galeriaimg_image_ext;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo galeriaimg_image_ext")
	    public String getGaleriaimg_image_ext() {
	    	Propiedades propiedad = Propiedades.galeriaimg_image_ext;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo galeriaimg_path_image")
	    public void setGaleriaimg_path_image(String valor) {
	    	Propiedades propiedad=Propiedades.galeriaimg_path_image;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo galeriaimg_path_image")
	    public String getGaleriaimg_path_image() {
	    	Propiedades propiedad = Propiedades.galeriaimg_path_image;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo google_nodo_AN")
	    public void setGoogle_nodo_AN(String valor) {
	    	Propiedades propiedad=Propiedades.google_nodo_AN;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo google_nodo_AN")
	    public String getGoogle_nodo_AN() {
	    	Propiedades propiedad = Propiedades.google_nodo_AN;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo google_nodo_AR")
	    public void setGoogle_nodo_AR(String valor) {
	    	Propiedades propiedad=Propiedades.google_nodo_AR;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo google_nodo_AR")
	    public String getGoogle_nodo_AR() {
	    	Propiedades propiedad = Propiedades.google_nodo_AR;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo google_nodo_AS")
	    public void setGoogle_nodo_AS(String valor) {
	    	Propiedades propiedad=Propiedades.google_nodo_AS;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo google_nodo_AS")
	    public String getGoogle_nodo_AS() {
	    	Propiedades propiedad = Propiedades.google_nodo_AS;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo google_nodo_CB")
	    public void setGoogle_nodo_CB(String valor) {
	    	Propiedades propiedad=Propiedades.google_nodo_CB;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo google_nodo_CB")
	    public String getGoogle_nodo_CB() {
	    	Propiedades propiedad = Propiedades.google_nodo_CB;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo google_nodo_CL")
	    public void setGoogle_nodo_CL(String valor) {
	    	Propiedades propiedad=Propiedades.google_nodo_CL;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo google_nodo_CL")
	    public String getGoogle_nodo_CL() {
	    	Propiedades propiedad = Propiedades.google_nodo_CL;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo google_nodo_CM")
	    public void setGoogle_nodo_CM(String valor) {
	    	Propiedades propiedad=Propiedades.google_nodo_CM;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo google_nodo_CM")
	    public String getGoogle_nodo_CM() {
	    	Propiedades propiedad = Propiedades.google_nodo_CM;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo google_nodo_CT")
	    public void setGoogle_nodo_CT(String valor) {
	    	Propiedades propiedad=Propiedades.google_nodo_CT;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo google_nodo_CT")
	    public String getGoogle_nodo_CT() {
	    	Propiedades propiedad = Propiedades.google_nodo_CT;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo google_nodo_CV")
	    public void setGoogle_nodo_CV(String valor) {
	    	Propiedades propiedad=Propiedades.google_nodo_CV;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo google_nodo_CV")
	    public String getGoogle_nodo_CV() {
	    	Propiedades propiedad = Propiedades.google_nodo_CV;
	    	return getPropiedad(propiedad);
	    }
//	    @ManagedAttribute(description="Atributo google_nodo_GL")
//	    public void setGoogle_nodo_GL(String valor) {
//	    	Propiedades propiedad=Propiedades.google_nodo_GL;
//	    	setPropiedad(valor, propiedad);
//	    }
//	    
//	    @ManagedAttribute(description="Atributo google_nodo_GL")
//	    public String getGoogle_nodo_GL() {
//	    	Propiedades propiedad = Propiedades.google_nodo_GL;
//	    	return getPropiedad(propiedad);
//	    }
	    @ManagedAttribute(description="Atributo google_nodo_EU")
	    public void setGoogle_nodo_EU(String valor) {
	    	Propiedades propiedad=Propiedades.google_nodo_EU;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo google_nodo_EU")
	    public String getGoogle_nodo_EU() {
	    	Propiedades propiedad = Propiedades.google_nodo_EU;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo google_nodo_EX")
	    public void setGoogle_nodo_EX(String valor) {
	    	Propiedades propiedad=Propiedades.google_nodo_EX;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo google_nodo_EX")
	    public String getGoogle_nodo_EX() {
	    	Propiedades propiedad = Propiedades.google_nodo_EX;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo google_nodo_GA")
	    public void setGoogle_nodo_GA(String valor) {
	    	Propiedades propiedad=Propiedades.google_nodo_GA;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo google_nodo_GA")
	    public String getGoogle_nodo_GA() {
	    	Propiedades propiedad = Propiedades.google_nodo_GA;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo google_nodo_IB")
	    public void setGoogle_nodo_IB(String valor) {
	    	Propiedades propiedad=Propiedades.google_nodo_IB;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo google_nodo_IB")
	    public String getGoogle_nodo_IB() {
	    	Propiedades propiedad = Propiedades.google_nodo_IB;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo google_nodo_IC")
	    public void setGoogle_nodo_IC(String valor) {
	    	Propiedades propiedad=Propiedades.google_nodo_IC;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo google_nodo_IC")
	    public String getGoogle_nodo_IC() {
	    	Propiedades propiedad = Propiedades.google_nodo_IC;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo google_nodo_LR")
	    public void setGoogle_nodo_LR(String valor) {
	    	Propiedades propiedad=Propiedades.google_nodo_LR;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo google_nodo_LR")
	    public String getGoogle_nodo_LR() {
	    	Propiedades propiedad = Propiedades.google_nodo_LR;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo google_nodo_MA")
	    public void setGoogle_nodo_MA(String valor) {
	    	Propiedades propiedad=Propiedades.google_nodo_MA;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo google_nodo_MA")
	    public String getGoogle_nodo_MA() {
	    	Propiedades propiedad = Propiedades.google_nodo_MA;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo google_nodo_MEC")
	    public void setGoogle_nodo_MEC(String valor) {
	    	Propiedades propiedad=Propiedades.google_nodo_MEC;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo google_nodo_MEC")
	    public String getGoogle_nodo_MEC() {
	    	Propiedades propiedad = Propiedades.google_nodo_MEC;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo google_nodo_MU")
	    public void setGoogle_nodo_MU(String valor) {
	    	Propiedades propiedad=Propiedades.google_nodo_MU;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo google_nodo_MU")
	    public String getGoogle_nodo_MU() {
	    	Propiedades propiedad = Propiedades.google_nodo_MU;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo google_nodo_NA")
	    public void setGoogle_nodo_NA(String valor) {
	    	Propiedades propiedad=Propiedades.google_nodo_NA;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo google_nodo_NA")
	    public String getGoogle_nodo_NA() {
	    	Propiedades propiedad = Propiedades.google_nodo_NA;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo identidad_federada")
	    public void setIdentidad_federada(String valor) {
	    	Propiedades propiedad=Propiedades.identidad_federada;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo identidad_federada")
	    public String getIdentidad_federada() {
	    	Propiedades propiedad = Propiedades.identidad_federada;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo ImagenDefectoGrupo1")
	    public void setImagenDefectoGrupo1(String valor) {
	    	Propiedades propiedad=Propiedades.ImagenDefectoGrupo1;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo ImagenDefectoGrupo1")
	    public String getImagenDefectoGrupo1() {
	    	Propiedades propiedad = Propiedades.ImagenDefectoGrupo1;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo ImagenDefectoGrupo2")
	    public void setImagenDefectoGrupo2(String valor) {
	    	Propiedades propiedad=Propiedades.ImagenDefectoGrupo2;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo ImagenDefectoGrupo2")
	    public String getImagenDefectoGrupo2() {
	    	Propiedades propiedad = Propiedades.ImagenDefectoGrupo2;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo ImagenDefectoGrupo3")
	    public void setImagenDefectoGrupo3(String valor) {
	    	Propiedades propiedad=Propiedades.ImagenDefectoGrupo3;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo ImagenDefectoGrupo3")
	    public String getImagenDefectoGrupo3() {
	    	Propiedades propiedad = Propiedades.ImagenDefectoGrupo3;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo ImagenDefectoGrupo4")
	    public void setImagenDefectoGrupo4(String valor) {
	    	Propiedades propiedad=Propiedades.ImagenDefectoGrupo4;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo ImagenDefectoGrupo4")
	    public String getImagenDefectoGrupo4() {
	    	Propiedades propiedad = Propiedades.ImagenDefectoGrupo4;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo ImagenDefectoGrupo5")
	    public void setImagenDefectoGrupo5(String valor) {
	    	Propiedades propiedad=Propiedades.ImagenDefectoGrupo5;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo ImagenDefectoGrupo5")
	    public String getImagenDefectoGrupo5() {
	    	Propiedades propiedad = Propiedades.ImagenDefectoGrupo5;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo ImagenDefectoUsuario")
	    public void setImagenDefectoUsuario(String valor) {
	    	Propiedades propiedad=Propiedades.ImagenDefectoUsuario;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo ImagenDefectoUsuario")
	    public String getImagenDefectoUsuario() {
	    	Propiedades propiedad = Propiedades.ImagenDefectoUsuario;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo imagenes_grupo_publico_url")
	    public void setImagenes_grupo_publico_url(String valor) {
	    	Propiedades propiedad=Propiedades.imagenes_grupo_publico_url;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo imagenes_grupo_publico_url")
	    public String getImagenes_grupo_publico_url() {
	    	Propiedades propiedad = Propiedades.imagenes_grupo_publico_url;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo imagenes_nodos_sqi_extensiones")
	    public void setImagenes_nodos_sqi_extensiones(String valor) {
	    	Propiedades propiedad=Propiedades.imagenes_nodos_sqi_extensiones;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo imagenes_nodos_sqi_extensiones")
	    public String getImagenes_nodos_sqi_extensiones() {
	    	Propiedades propiedad = Propiedades.imagenes_nodos_sqi_extensiones;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo imagenes_usuario_publico_url")
	    public void setImagenes_usuario_publico_url(String valor) {
	    	Propiedades propiedad=Propiedades.imagenes_usuario_publico_url;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo imagenes_usuario_publico_url")
	    public String getImagenes_usuario_publico_url() {
	    	Propiedades propiedad = Propiedades.imagenes_usuario_publico_url;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo imgBirtDir")
	    public void setImgBirtDir(String valor) {
	    	Propiedades propiedad=Propiedades.imgBirtDir;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo imgBirtDir")
	    public String getImgBirtDir() {
	    	Propiedades propiedad = Propiedades.imgBirtDir;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo informesDir")
	    public void setInformesDir(String valor) {
	    	Propiedades propiedad=Propiedades.informesDir;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo informesDir")
	    public String getInformesDir() {
	    	Propiedades propiedad = Propiedades.informesDir;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo integracionLdap")
	    public void setIntegracionLdap(String valor) {
	    	Propiedades propiedad=Propiedades.integracionLdap;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo integracionLdap")
	    public String getIntegracionLdap() {
	    	Propiedades propiedad = Propiedades.integracionLdap;
	    	return getPropiedad(propiedad);
	    }

	    @ManagedAttribute(description="Atributo ldapmanagerPasswd")
	    public void setLdapmanagerPasswd(String valor) {
	    	Propiedades propiedad=Propiedades.ldapmanagerPasswd;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo ldapmanagerPasswd")
	    public String getLdapmanagerPasswd() {
	    	Propiedades propiedad = Propiedades.ldapmanagerPasswd;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo ldappath")
	    public void setLdappath(String valor) {
	    	Propiedades propiedad=Propiedades.ldappath;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo ldappath")
	    public String getLdappath() {
	    	Propiedades propiedad = Propiedades.ldappath;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo ldapurl")
	    public void setLdapurl(String valor) {
	    	Propiedades propiedad=Propiedades.ldapurl;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo ldapurl")
	    public String getLdapurl() {
	    	Propiedades propiedad = Propiedades.ldapurl;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo ldapusuariosbindsubpath")
	    public void setLdapusuariosbindsubpath(String valor) {
	    	Propiedades propiedad=Propiedades.ldapusuariosbindsubpath;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo ldapusuariosbindsubpath")
	    public String getLdapusuariosbindsubpath() {
	    	Propiedades propiedad = Propiedades.ldapusuariosbindsubpath;
	    	return getPropiedad(propiedad);
	    }

	    @ManagedAttribute(description="Atributo maxWaitPoolSQI")
	    public void setMaxWaitPoolSQI(String valor) {
	    	Propiedades propiedad=Propiedades.maxWaitPoolSQI;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo maxWaitPoolSQI")
	    public String getMaxWaitPoolSQI() {
	    	Propiedades propiedad = Propiedades.maxWaitPoolSQI;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo maxWaitThreadSQI")
	    public void setMaxWaitThreadSQI(String valor) {
	    	Propiedades propiedad=Propiedades.maxWaitThreadSQI;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo maxWaitThreadSQI")
	    public String getMaxWaitThreadSQI() {
	    	Propiedades propiedad = Propiedades.maxWaitThreadSQI;
	    	return getPropiedad(propiedad);
	    }
	    	
	    @ManagedAttribute(description="Atributo nodo_taller")
	    public void setNodo_taller(String valor) {
	    	Propiedades propiedad=Propiedades.nodo_taller;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo nodo_taller")
	    public String getNodo_taller() {
	    	Propiedades propiedad = Propiedades.nodo_taller;
	    	return getPropiedad(propiedad);
	    }

	    @ManagedAttribute(description="Atributo nombre_imagen_repositorio_externo_defecto")
	    public void setNombre_imagen_repositorio_externo_defecto(String valor) {
	    	Propiedades propiedad=Propiedades.nombre_imagen_repositorio_externo_defecto;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo nombre_imagen_repositorio_externo_defecto")
	    public String getNombre_imagen_repositorio_externo_defecto() {
	    	Propiedades propiedad = Propiedades.nombre_imagen_repositorio_externo_defecto;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo nombreInformesPortadaSemanales")
	    public void setNombreInformesPortadaSemanales(String valor) {
	    	Propiedades propiedad=Propiedades.nombreInformesPortadaSemanales;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo nombreInformesPortadaSemanales")
	    public String getNombreInformesPortadaSemanales() {
	    	Propiedades propiedad = Propiedades.nombreInformesPortadaSemanales;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo nombreRepositorio")
	    public void setNombreRepositorio(String valor) {
	    	Propiedades propiedad=Propiedades.nombreRepositorio;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo nombreRepositorio")
	    public String getNombreRepositorio() {
	    	Propiedades propiedad = Propiedades.nombreRepositorio;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo path_generatedimgs")
	    public void setPath_generatedimgs(String valor) {
	    	Propiedades propiedad=Propiedades.path_generatedimgs;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo path_generatedimgs")
	    public String getPath_generatedimgs() {
	    	Propiedades propiedad = Propiedades.path_generatedimgs;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo path_imagenes_grupo_publico")
	    public void setPath_imagenes_grupo_publico(String valor) {
	    	Propiedades propiedad=Propiedades.path_imagenes_grupo_publico;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo path_imagenes_grupo_publico")
	    public String getPath_imagenes_grupo_publico() {
	    	Propiedades propiedad = Propiedades.path_imagenes_grupo_publico;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo path_imagenes_nodos_sqi")
	    public void setPath_imagenes_nodos_sqi(String valor) {
	    	Propiedades propiedad=Propiedades.path_imagenes_nodos_sqi;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo path_imagenes_nodos_sqi")
	    public String getPath_imagenes_nodos_sqi() {
	    	Propiedades propiedad = Propiedades.path_imagenes_nodos_sqi;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo path_imagenes_usuario_publico")
	    public void setPath_imagenes_usuario_publico(String valor) {
	    	Propiedades propiedad=Propiedades.path_imagenes_usuario_publico;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo path_imagenes_usuario_publico")
	    public String getPath_imagenes_usuario_publico() {
	    	Propiedades propiedad = Propiedades.path_imagenes_usuario_publico;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo pathDespublicacionMasiva")
	    public void setPathDespublicacionMasiva(String valor) {
	    	Propiedades propiedad=Propiedades.pathDespublicacionMasiva;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo pathDespublicacionMasiva")
	    public String getPathDespublicacionMasiva() {
	    	Propiedades propiedad = Propiedades.pathDespublicacionMasiva;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo pathImagenDefecto")
	    public void setPathImagenDefecto(String valor) {
	    	Propiedades propiedad=Propiedades.pathImagenDefecto;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo pathImagenDefecto")
	    public String getPathImagenDefecto() {
	    	Propiedades propiedad = Propiedades.pathImagenDefecto;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo pathImagenDefectoMedia")
	    public void setPathImagenDefectoMedia(String valor) {
	    	Propiedades propiedad=Propiedades.pathImagenDefectoMedia;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo pathImagenDefectoMedia")
	    public String getPathImagenDefectoMedia() {
	    	Propiedades propiedad = Propiedades.pathImagenDefectoMedia;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo pathImagenDefectoPeque")
	    public void setPathImagenDefectoPeque(String valor) {
	    	Propiedades propiedad=Propiedades.pathImagenDefectoPeque;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo pathImagenDefectoPeque")
	    public String getPathImagenDefectoPeque() {
	    	Propiedades propiedad = Propiedades.pathImagenDefectoPeque;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo pathIndiceNodos")
	    public void setPathIndiceNodos(String valor) {
	    	Propiedades propiedad=Propiedades.pathIndiceNodos;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo pathIndiceNodos")
	    public String getPathIndiceNodos() {
	    	Propiedades propiedad = Propiedades.pathIndiceNodos;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo pathIndice")
	    public void setPathIndice(String valor) {
	    	Propiedades propiedad=Propiedades.pathIndice;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo pathIndice")
	    public String getPathIndice() {
	    	Propiedades propiedad = Propiedades.pathIndice;
	    	return getPropiedad(propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo pathInformesPortada")
	    public void setPathInformesPortada(String valor) {
	    	Propiedades propiedad=Propiedades.pathInformesPortada;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo pathInformesPortada")
	    public String getPathInformesPortada() {
	    	Propiedades propiedad = Propiedades.pathInformesPortada;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo pathPlantillasCorreo")
	    public void setPathPlantillasCorreo(String valor) {
	    	Propiedades propiedad=Propiedades.pathPlantillasCorreo;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo pathPlantillasCorreo")
	    public String getPathPlantillasCorreo() {
	    	Propiedades propiedad = Propiedades.pathPlantillasCorreo;
	    	return getPropiedad(propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo rangoInformesPortada")
	    public void setRangoInformesPortada(String valor) {
	    	Propiedades propiedad=Propiedades.rangoInformesPortada;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo rangoInformesPortada")
	    public String getRangoInformesPortada() {
	    	Propiedades propiedad = Propiedades.rangoInformesPortada;
	    	return getPropiedad(propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo rss")
	    public void setRss(String valor) {
	    	Propiedades propiedad=Propiedades.rss;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo rss")
	    public String getRss() {
	    	Propiedades propiedad = Propiedades.rss;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo rss_federado_timeout")
	    public void setRss_federado_timeout(String valor) {
	    	Propiedades propiedad=Propiedades.rss_federado_timeout;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo rss_federado_timeout")
	    public String getRss_federado_timeout() {
	    	Propiedades propiedad = Propiedades.rss_federado_timeout;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo rss_path")
	    public void setRss_path(String valor) {
	    	Propiedades propiedad=Propiedades.rss_path;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo rss_path")
	    public String getRss_path() {
	    	Propiedades propiedad = Propiedades.rss_path;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo searchPlugin")
	    public void setSearchPlugin(String valor) {
	    	Propiedades propiedad=Propiedades.searchPlugin;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo searchPlugin")
	    public String getSearchPlugin() {
	    	Propiedades propiedad = Propiedades.searchPlugin;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo segundosCaducidadHit")
	    public void setSegundosCaducidadHit(String valor) {
	    	Propiedades propiedad=Propiedades.segundosCaducidadHit;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo segundosCaducidadHit")
	    public String getSegundosCaducidadHit() {
	    	Propiedades propiedad = Propiedades.segundosCaducidadHit;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo server.on")
	    public void setServerOn(String valor) {
	    	Propiedades propiedad=Propiedades.server_on;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo server.on")
	    public String getServerOn() {
	    	Propiedades propiedad = Propiedades.server_on;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo staticImgDir")
	    public void setStaticImgDir(String valor) {
	    	Propiedades propiedad=Propiedades.staticImgDir;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo staticImgDir")
	    public String getStaticImgDir() {
	    	Propiedades propiedad = Propiedades.staticImgDir;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo subdominio")
	    public void setSubdominio(String valor) {
	    	Propiedades propiedad=Propiedades.subdominio;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo subdominio")
	    public String getSubdominio() {
	    	Propiedades propiedad = Propiedades.subdominio;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo tiempoRefresco")
	    public void setTiempoRefresco(String valor) {
	    	Propiedades propiedad=Propiedades.tiempoRefresco;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo tiempoRefresco")
	    public String getTiempoRefresco() {
	    	Propiedades propiedad = Propiedades.tiempoRefresco;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo timeout_autenticado")
	    public void setTimeout_autenticado(String valor) {
	    	Propiedades propiedad=Propiedades.timeout_autenticado;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo timeout_autenticado")
	    public String getTimeout_autenticado() {
	    	Propiedades propiedad = Propiedades.timeout_autenticado;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo timeout_extendido")
	    public void setTimeout_extendido(String valor) {
	    	Propiedades propiedad=Propiedades.timeout_extendido;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo timeout_extendido")
	    public String getTimeout_extendido() {
	    	Propiedades propiedad = Propiedades.timeout_extendido;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo timeoutCookieOpenId")
	    public void setTimeoutCookieOpenId(String valor) {
	    	Propiedades propiedad=Propiedades.timeoutCookieOpenId;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo timeoutCookieOpenId")
	    public String getTimeoutCookieOpenId() {
	    	Propiedades propiedad = Propiedades.timeoutCookieOpenId;
	    	return getPropiedad(propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo timeout_identidad_federada")
	    public void setTimeoutIdentidadFederada(String valor) {
	    	Propiedades propiedad=Propiedades.timeout_identidad_federada;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo timeout_identidad_federada")
	    public String getTimeoutIdentidadFederada() {
	    	Propiedades propiedad = Propiedades.timeout_identidad_federada;
	    	return getPropiedad(propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo url_logout_taller")
	    public void setUrl_logout_taller(String valor) {
	    	Propiedades propiedad=Propiedades.url_logout_taller;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo url_logout_taller")
	    public String getUrl_logout_taller() {
	    	Propiedades propiedad = Propiedades.url_logout_taller;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo url_licencias")
	    public void setUrl_licencias(String valor) {
	    	Propiedades propiedad=Propiedades.url_licencias;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo url_licencias")
	    public String getUrl_licencias() {
	    	Propiedades propiedad = Propiedades.url_licencias;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo urlRepositorio")
	    public void setUrlRepositorio(String valor) {
	    	Propiedades propiedad=Propiedades.urlRepositorio;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo urlRepositorio")
	    public String getUrlRepositorio() {
	    	Propiedades propiedad = Propiedades.urlRepositorio;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo usercnprefix")
	    public void setUserCNPrefix(String valor) {
	    	Propiedades propiedad=Propiedades.usercnprefix;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo usercnprefix")
	    public String getUserCNPrefix() {
	    	Propiedades propiedad = Propiedades.usercnprefix;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo version")
	    public void setVersion(String valor) {
	    	Propiedades propiedad=Propiedades.version;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo version")
	    public String getVersion() {
	    	Propiedades propiedad = Propiedades.version;
	    	return getPropiedad(propiedad);
	    }
	    
//	    @ManagedAttribute(description="Atributo vistaPreviaAgrega")
//	    public void setVistaPreviaAgrega(String valor) {
//	    	Propiedades propiedad=Propiedades.vistaPreviaAgrega;
//	    	setPropiedad(valor, propiedad);
//	    }
//	    
	    @ManagedAttribute(description="Atributo vistaPreviaAgrega")
	    public String getVistaPreviaAgrega() {
	    	Propiedades propiedad = Propiedades.vistaPreviaAgrega;
	    	return getPropiedad(propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo ccaa")
	    public void setCcaa(String valor) {
	    	Propiedades propiedad=Propiedades.ccaa;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo ccaa")
	    public String getCcaa() {
	    	Propiedades propiedad = Propiedades.ccaa;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo contacto_telefono")
	    public void setContacto_telefono(String valor) {
	    	Propiedades propiedad=Propiedades.contacto_telefono;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo contacto_telefono")
	    public String getContacto_telefono() {
	    	Propiedades propiedad = Propiedades.contacto_telefono;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo contacto_incidencias_activar")
	    public void setContacto_incidencias_activar(String valor) {
	    	Propiedades propiedad=Propiedades.contacto_incidencias_activar;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo contacto_incidencias_activar")
	    public String getContacto_incidencias_activar() {
	    	Propiedades propiedad = Propiedades.contacto_incidencias_activar;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo contacto_mail")
	    public void setContacto_mail(String valor) {
	    	Propiedades propiedad=Propiedades.contacto_mail;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo contacto_mail")
	    public String getContacto_mail() {
	    	Propiedades propiedad = Propiedades.contacto_mail;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo host")
	    public void setHost(String valor) {
	    	Propiedades propiedad=Propiedades.host;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo host")
	    public String getHost() {
	    	Propiedades propiedad = Propiedades.host;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo puerto_jboss")
	    public void setPuerto_jboss(String valor) {
	    	Propiedades propiedad=Propiedades.puerto_jboss;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo puerto_jboss")
	    public String getPuerto_jboss() {
	    	Propiedades propiedad = Propiedades.puerto_jboss;
	    	return getPropiedad(propiedad);
	    }
	    @ManagedAttribute(description="Atributo subdominio_jboss")
	    public void setSubdominio_jboss(String valor) {
	    	Propiedades propiedad=Propiedades.subdominio_jboss;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo subdominio_jboss")
	    public String getSubdominio_jboss() {
	    	Propiedades propiedad = Propiedades.subdominio_jboss;
	    	return getPropiedad(propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo rolebindsubpath")
	    public void setRolebindsubpath(String valor) {
	    	Propiedades propiedad=Propiedades.rolebindsubpath;
	    	setPropiedad(valor, propiedad);
	    }
	    
	    @ManagedAttribute(description="Atributo rolebindsubpath")
	    public String getRolebindsubpath() {
	    	Propiedades propiedad = Propiedades.rolebindsubpath;
	    	return getPropiedad(propiedad);
	    }


		@ManagedAttribute(description="Atributo estadisticas_path")
	    public String getEstadisticas_path() {
	    	Propiedades propiedad = Propiedades.estadisticas_path;
	    	return getPropiedad(propiedad);
	    }

		@ManagedAttribute(description="Atributo indexServer_url")
	    public String getIndexServer_url() {
	    	Propiedades propiedad = Propiedades.indexServer_url;
	    	return getPropiedad(propiedad);
	    }

		@ManagedAttribute(description="Atributo indexServer_port")
	    public String getIndexServer_port() {
	    	Propiedades propiedad = Propiedades.indexServer_port;
	    	return getPropiedad(propiedad);
	    }

		@ManagedAttribute(description="Atributo indexServer_user")
	    public String getIndexServer_user() {
	    	Propiedades propiedad = Propiedades.indexServer_user;
	    	return getPropiedad(propiedad);
	    }

		@ManagedAttribute(description="Atributo indexServer_password")
	    public String getIndexServer_password() {
	    	Propiedades propiedad = Propiedades.indexServer_password;
	    	return getPropiedad(propiedad);
	    }

		@ManagedAttribute(description="Atributo index_upload_path")
	    public String getIndex_upload_path() {
	    	Propiedades propiedad = Propiedades.index_upload_path;
	    	return getPropiedad(propiedad);
	    }

		@ManagedAttribute(description="Atributo numDescargasMostradasEnResumen")
	    public String getNumDescargasMostradasEnResumen() {
	    	Propiedades propiedad = Propiedades.numDescargasMostradasEnResumen;
	    	return getPropiedad(propiedad);
	    }

		@ManagedAttribute(description="Atributo numNoticiasMostradasEnResumen")
	    public String getNumNoticiasMostradasEnResumen() {
	    	Propiedades propiedad = Propiedades.numNoticiasMostradasEnResumen;
	    	return getPropiedad(propiedad);
	    }

		@ManagedAttribute(description="Atributo check_password")
	    public String getCheck_password() {
	    	Propiedades propiedad = Propiedades.check_password;
	    	return getPropiedad(propiedad);
	    }

		@ManagedAttribute(description="Atributo secuencia_sin_logar")
	    public String getSecuencia_sin_logar() {
	    	Propiedades propiedad = Propiedades.secuencia_sin_logar;
	    	return getPropiedad(propiedad);
	    }

		@ManagedAttribute(description="Atributo numeroOdesEnFlash")
	    public String getNumeroOdesEnFlash() {
	    	Propiedades propiedad = Propiedades.numeroOdesEnFlash;
	    	return getPropiedad(propiedad);
	    }

		@ManagedAttribute(description="Atributo rememberme")
	    public String getRememberme() {
	    	Propiedades propiedad = Propiedades.rememberme;
	    	return getPropiedad(propiedad);
	    }

		@ManagedAttribute(description="Atributo perfilPublico")
	    public String getPerfilPublico() {
	    	Propiedades propiedad = Propiedades.perfilPublico;
	    	return getPropiedad(propiedad);
	    }

		@ManagedAttribute(description="Atributo rest_resultados_por_pagina")
	    public String getRest_resultados_por_pagina() {
	    	Propiedades propiedad = Propiedades.rest_resultados_por_pagina;
	    	return getPropiedad(propiedad);
	    }

		@ManagedAttribute(description="Atributo numeroTags")
	    public String getNumeroTags() {
	    	Propiedades propiedad = Propiedades.numeroTags;
	    	return getPropiedad(propiedad);
	    }

		@ManagedAttribute(description="Atributo informesPortada")
	    public String getInformesPortada() {
	    	Propiedades propiedad = Propiedades.informesPortada;
	    	return getPropiedad(propiedad);
	    }

		@ManagedAttribute(description="Atributo valorCuotaDefecto")
	    public String getValorCuotaDefecto() {
	    	Propiedades propiedad = Propiedades.valorCuotaDefecto;
	    	return getPropiedad(propiedad);
	    }

		@ManagedAttribute(description="Atributo export_cache_size")
	    public String getExport_cache_size() {
	    	Propiedades propiedad = Propiedades.export_cache_size;
	    	return getPropiedad(propiedad);
	    }

		@ManagedAttribute(description="Atributo tiempolimite")
	    public String getTiempolimite() {
	    	Propiedades propiedad = Propiedades.tiempolimite;
	    	return getPropiedad(propiedad);
	    }

		@ManagedAttribute(description="Atributo emailAdmin")
	    public String getEmailAdmin() {
	    	Propiedades propiedad = Propiedades.emailAdmin;
	    	return getPropiedad(propiedad);
	    }

		@ManagedAttribute(description="Atributo urlConsejeriaNodo")
	    public String getUrlConsejeriaNodo() {
	    	Propiedades propiedad = Propiedades.urlConsejeriaNodo;
	    	return getPropiedad(propiedad);
	    }

		@ManagedAttribute(description="Atributo server_id")
	    public String getServer_id() {
	    	Propiedades propiedad = Propiedades.server_id;
	    	return getPropiedad(propiedad);
	    }

		@ManagedAttribute(description="Atributo proxy")
	    public String getProxy() {
	    	Propiedades propiedad = Propiedades.proxy;
	    	return getPropiedad(propiedad);
	    }

		@ManagedAttribute(description="Atributo proxy_host")
	    public String getProxy_host() {
	    	Propiedades propiedad = Propiedades.proxy_host;
	    	return getPropiedad(propiedad);
	    }

		@ManagedAttribute(description="Atributo proxy_port")
	    public String getProxy_port() {
	    	Propiedades propiedad = Propiedades.proxy_port;
	    	return getPropiedad(propiedad);
	    }

		@ManagedAttribute(description="Atributo proxy_user")
	    public String getProxy_user() {
	    	Propiedades propiedad = Propiedades.proxy_user;
	    	return getPropiedad(propiedad);
	    }

		@ManagedAttribute(description="Atributo proxy_passwd")
	    public String getProxy_passwd() {
	    	Propiedades propiedad = Propiedades.proxy_passwd;
	    	return getPropiedad(propiedad);
	    }

		@ManagedAttribute(description="Atributo ldap_external")
	    public String getLdap_external() {
	    	Propiedades propiedad = Propiedades.ldap_external;
	    	return getPropiedad(propiedad);
	    }

		@ManagedAttribute(description="Atributo ldap_external_admin")
	    public String getLdap_external_admin() {
	    	Propiedades propiedad = Propiedades.ldap_external_admin;
	    	return getPropiedad(propiedad);
	    }

		@ManagedAttribute(description="Atributo timeZone")
	    public String getTimeZone() {
	    	Propiedades propiedad = Propiedades.timeZone;
	    	return getPropiedad(propiedad);
	    }

		@ManagedAttribute(description="Atributo smtp_host")
	    public String getSmtp_host() {
	    	Propiedades propiedad = Propiedades.smtp_host;
	    	return getPropiedad(propiedad);
	    }

		@ManagedAttribute(description="Atributo smtp_sender")
	    public String getSmtp_sender() {
	    	Propiedades propiedad = Propiedades.smtp_sender;
	    	return getPropiedad(propiedad);
	    }

		@ManagedAttribute(description="Atributo smtp_autentication")
	    public String getSmtp_autentication() {
	    	Propiedades propiedad = Propiedades.smtp_autentication;
	    	return getPropiedad(propiedad);
	    }

		@ManagedAttribute(description="Atributo smtp_user")
	    public String getSmtp_user() {
	    	Propiedades propiedad = Propiedades.smtp_user;
	    	return getPropiedad(propiedad);
	    }

		@ManagedAttribute(description="Atributo smtp_passwd")
	    public String getSmtp_passwd() {
	    	Propiedades propiedad = Propiedades.smtp_passwd;
	    	return getPropiedad(propiedad);
	    }
		
		@ManagedAttribute(description="Atributo server_path")
	    public String getServerPath() {
	    	Propiedades propiedad = Propiedades.server_path;
	    	return getPropiedad(propiedad);
	    }
		
		@ManagedAttribute(description="Atributo debug")
	    public String getDebug() {
	    	Propiedades propiedad = Propiedades.debug;
	    	return getPropiedad(propiedad);
	    }
		
		@ManagedAttribute(description="Atributo export_cache_tiempo")
	    public String getExportCacheTiempo() {
	    	Propiedades propiedad = Propiedades.export_cache_tiempo;
	    	return getPropiedad(propiedad);
	    }
		
	    @ManagedAttribute(description="Atributo publicadosAutonomosHabilitado")
	    public void setPublicadosAutonomosHabilitado(String valor) {
	    	Propiedades propiedad=Propiedades.publicadosAutonomosHabilitado;
	    	setPropiedad(valor, propiedad);
	    }
		@ManagedAttribute(description="Atributo publicadosAutonomosHabilitado")
	    public String getPublicadosAutonomosHabilitado() {
	    	Propiedades propiedad = Propiedades.publicadosAutonomosHabilitado;
	    	return getPropiedad(propiedad);
	    }
	    
/** 
 * Metodo que hay que implementar del interfaz NotificationPublisherAware 
 */ 	    
//	    public void setNotificationPublisher(NotificationPublisher notificationPublisher) {
//	        this.publisher = notificationPublisher;
//	    }

		String[] sustituir(String fileName, String destino, Propiedades[] variables) {
			try {
				logger.debug("Fichero "+fileName);
				ArrayList<String> mensajes = new ArrayList<String>();
//				File origen = new File(fileName);
				InputStream is=PropiedadJmxServiceImpl.class.getResourceAsStream("/"+fileName);
//				File destinoFile = new File(destino+fileName);
//				UtilesFicheros.copiar(origen,destinoFile);
				copiar(is,destino+fileName);
				String contenido = IOUtils.toString(new FileInputStream(destino+fileName), ENCODING);
				for (int i = 0; i < variables.length; i++) {
					Propiedades propiedad = variables[i];
					String plantilla = "\\$\\{"+propiedad.getNombre()+"\\}";
					contenido = contenido.replaceAll(plantilla, propiedad.getValor());
					mensajes.add(propiedad.getNombre()+": "+OK);
					logger.debug(propiedad.getNombre()+": "+propiedad.getValor());
				}
				
				IOUtils.write(contenido, new FileOutputStream(destino+fileName), ENCODING);
				return mensajes.toArray(new String[]{});
			} catch (Exception e) {
				logger.debug(e.fillInStackTrace());
				return new String[]{e.getLocalizedMessage()};
			}
		}	    

	    private String[] rellenaPropiedad(PropiedadVO propiedad)
	    throws Exception {
	    	Propiedades propiedadEnum = Propiedades.getPropiedad(propiedad.getNombre());
	    	String[] fileList=propiedadEnum.getFileList().split(Ficheros.SEPARADOR);
	    	logger.debug("Rellenamos propiedad "+propiedad.getNombre()+", fileList es "+propiedadEnum.getFileList());
	    	String[] mensajes = new String[fileList.length];
	    	for (int i = 0; i < fileList.length; i++) {
	    		String destino=Ficheros.getFichero(fileList[i]).getDestino();
	    		mensajes[i]=sustituir(fileList[i], destino, Propiedades.values())[0];
	    	}

	    	return mensajes;
	    }

	    private static void copiar(InputStream fileOrigen, String fileDestino) throws Exception 
	    {
	    	OutputStream os=null;
	    	File newFile = new File(fileDestino);
	    	try{
	    		//Por si el fichero no existe en primera ejecuci�n
	    		if(newFile.createNewFile()) {
	    			logger.debug("No exist�a fichero destino, se crea vac�o ");
	    		}
	    		os = new BufferedOutputStream(new FileOutputStream (newFile));
	    		UtilesFicheros.copiar(fileOrigen, os);

	    	}catch(Exception e){
	    		throw new Exception ("Estas intentando copiar un directorio en un archivo",e);
	    	} finally {
	    		if(fileOrigen!=null) fileOrigen.close();
	    		if(os!=null) os.close();
	    	}
}
}