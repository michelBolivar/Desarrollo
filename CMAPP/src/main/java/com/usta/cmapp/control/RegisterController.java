package com.usta.cmapp.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.coronavirus_mysql.model.Empresa;
import com.coronavirus_mysql.model.Enfermedade;
import com.coronavirus_mysql.model.Persona;
import com.coronavirus_mysql.model.Registro;
import com.usta.cmapp.constants.EnumDataBase;
import com.usta.coronavirus.service.ServicesDao;

@ManagedBean(name = "registro")
@SessionScoped
public class RegisterController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Properties properties;
	private Registro registerPerson;
	private String userAcces;
	private String usLoged;
	private List<Empresa> listaEmpresa;
	private List<Enfermedade> listaEnfermedad;
	private String document;
	private boolean visiblePanel;
	private Persona personRegis;
	private Float imc;
	private String resultaImc;

	@EJB
	private ServicesDao<Object> servicesDao;

	public RegisterController() {

		properties = new Properties();
		userAcces = null;
		registerPerson = new Registro();
		listaEmpresa = new ArrayList<Empresa>();
		listaEnfermedad = new ArrayList<Enfermedade>();
		document = null;
		visiblePanel = false;
		imc = 0.0F;
		resultaImc = null;
		personRegis = new Persona();

		chargeProperties();

	}

	private void chargeProperties() {

		try {
			properties.load(RegisterController.class.getResourceAsStream("messages.properties"));
			userAcces = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
					.get(LoginController.USER_AUTENTICH.toUpperCase());

			usLoged = ((String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
					.get(LoginController.AUTH_KEY)).toUpperCase();

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					properties.getProperty("errorGeneral"), properties.getProperty("errorCargarPropiedades")));
		}
	}

	@PostConstruct
	public void chargeData() {

		try {

			List<Object> enfermedad = servicesDao.findAll(Enfermedade.class, EnumDataBase.MYSQL.getId());

			for (Object o : enfermedad) {

				listaEnfermedad.add((Enfermedade) o);
			}

			List<Object> empresa = servicesDao.findAll(Empresa.class, EnumDataBase.MYSQL.getId());
			for (Object o : empresa) {

				listaEmpresa.add((Empresa) o);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void validatePerson() {

		try {
			if (document != null && !document.equals("")) {

				personRegis = (Persona) servicesDao.searchPersonByDocument(document, EnumDataBase.MYSQL.getId());

				if (personRegis != null && !personRegis.equals("")) {
					registerPerson.setIdPersona(personRegis.getIdPersona());
					visiblePanel = true;
				} else {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
							properties.getProperty(""), properties.getProperty("")));
				}

			}

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					properties.getProperty(""), properties.getProperty("")));
		}

	}

	public void regisInto() {

		try {
			if(personRegis.getPeso()>0 && registerPerson.getTemperatura()>0) {
				if(registerPerson.getTemperatura()<38 && registerPerson.getTemperatura()>35) {
					//registerPerson.setFechaIngreso(fechaIngreso);
					//registerPerson.setEntryDate(new Date());
					registerPerson.setSintomas(Byte.valueOf("0"));
					servicesDao.create(registerPerson, EnumDataBase.MYSQL.getId());
					imc = Float.valueOf(personRegis.getPeso())/ Float.valueOf((float) Math.pow(Double.valueOf(personRegis.getEstatura()), 2));
					
					resultaImc = personRegis.getGenero().equals("male") ? (imc > 25 ? 
							"SOBREPESO".concat(imc.toString()) : "NORMAL".concat(imc.toString())) 
							: (imc > 24 ? "SOBREPESO".concat(imc.toString()) : "NORMAL".concat(imc.toString()));
					
				}
			}
		} catch (Exception e) {
			
		}

	}

	public final Properties getProperties() {
		return properties;
	}

	public final void setProperties(Properties properties) {
		this.properties = properties;
	}

	public final Registro getRegisterPerson() {
		return registerPerson;
	}

	public final void setRegisterPerson(Registro registerPerson) {
		this.registerPerson = registerPerson;
	}

	public final String getUserAcces() {
		return userAcces;
	}

	public final void setUserAcces(String userAcces) {
		this.userAcces = userAcces;
	}

	public final String getUsLoged() {
		return usLoged;
	}

	public final void setUsLoged(String usLoged) {
		this.usLoged = usLoged;
	}

	public final List<Empresa> getListaEmpresa() {
		return listaEmpresa;
	}

	public final void setListaEmpresa(List<Empresa> listaEmpresa) {
		this.listaEmpresa = listaEmpresa;
	}

	public final List<Enfermedade> getListaEnfermedad() {
		return listaEnfermedad;
	}

	public final void setListaEnfermedad(List<Enfermedade> listaEnfermedad) {
		this.listaEnfermedad = listaEnfermedad;
	}

	public final String getDocument() {
		return document;
	}

	public final void setDocument(String document) {
		this.document = document;
	}

	public final boolean isVisiblePanel() {
		return visiblePanel;
	}

	public final void setVisiblePanel(boolean visiblePanel) {
		this.visiblePanel = visiblePanel;
	}

	public final Persona getPersonRegis() {
		return personRegis;
	}

	public final void setPersonRegis(Persona personRegis) {
		this.personRegis = personRegis;
	}
}
