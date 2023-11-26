package com.miempresa;

import com.miempresa.GeneradorDeNombresA;
import com.miempresa.GeneradorDeNombresAImpl;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
    private ServiceRegistration registration;

    public void start(BundleContext context) {
        System.out.println("Activator 1");
        GeneradorDeNombresA servicio = new GeneradorDeNombresAImpl();
        registration = context.registerService(GeneradorDeNombresA.class.getName(), servicio, null);
    }

    public void stop(BundleContext context) {
        registration.unregister();
    }
}
