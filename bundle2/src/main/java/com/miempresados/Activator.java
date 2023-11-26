package com.miempresados;

import com.miempresa.GeneradorDeNombresA;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import java.util.List;
public class Activator implements BundleActivator {
    private ServiceRegistration registration;
    public void start(BundleContext context) {
        System.out.println("Activator2");
        GeneradorDeNombresB generadorB = new GeneradorDeNombresB();
        List<String> nombresB = generadorB.generarNombres();
        for (String nombre : nombresB) {
            System.out.println(nombre);
        }

        // Registra el servicio GeneradorDeNombresB
        registration = context.registerService(GeneradorDeNombresB.class.getName(), generadorB, null);

        ServiceReference reference = context.getServiceReference(GeneradorDeNombresA.class.getName());
        if (reference != null) {
            GeneradorDeNombresA generadorA = (GeneradorDeNombresA) context.getService(reference);
            List<String> nombresA = generadorA.generarNombres();
            for (String nombre : nombresA) {
                System.out.println(nombre);
            }
        }
    }

    public void stop(BundleContext context) {
        registration.unregister();
    }
}
