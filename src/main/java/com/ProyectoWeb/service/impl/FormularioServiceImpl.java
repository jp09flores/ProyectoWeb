package com.ProyectoWeb.service.impl;

import com.ProyectoWeb.dao.FormularioDao;
import com.ProyectoWeb.domain.Formulario;
import com.ProyectoWeb.service.CorreoService;
import com.ProyectoWeb.service.FormularioService;
import jakarta.mail.MessagingException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FormularioServiceImpl implements FormularioService {

    @Autowired
    FormularioDao formularioDao;
    
    @Autowired
    private MessageSource messageSource;
    
    @Autowired
    private CorreoService correoService;

    @Override
    @Transactional
    public void save(Formulario formulario) {
        formularioDao.save(formulario);
        try {
            enviaCorreoActivar(formulario);
        } catch (MessagingException ex) {
            Logger.getLogger(FormularioServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void enviaCorreoActivar( Formulario formulario) throws MessagingException {
        String mensaje = "<h1>Querido "+formulario.getNombre()+" "+formulario.getApellidos()+"</h1>\n Gracias por Contar con nosotros para recibir notificaicones sobre la tienda, proximamente nos pondremos en contacto contigo para mas informacion"
                + "\n\n<img src=\"https://scontent.fsyq2-1.fna.fbcdn.net/v/t39.30808-6/292295596_462566802537738_5453104257751830507_n.jpg?_nc_cat=110&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=yp5bvcVnfSgAX9vBBNA&_nc_ht=scontent.fsyq2-1.fna&oh=00_AfDj5XPhqZJZBLDO4QvCaxbECbsBrhUU5Atn7V0gvu0XIg&oe=64E54D88\"/>";
        String asunto = "Gracias De parte de Donde John";
        correoService.enviarCorreo(formulario.getCorreo(), asunto, mensaje);
    }

}
