package org.example.PrevaluacionPresencial;

 class ConfiguracionSistema {
    // Al ser static, este atributo pertenece a la clase
    // y guarda la referencia a la instancia compartida.
    private static ConfiguracionSistema instancia;

    private String idioma;

    private ConfiguracionSistema() {
        // Asigná "Español" al atributo idioma.
        this.idioma = "Español";
        // El constructor es privado para impedir que otras clases
        // creen objetos directamente con new ConfiguracionSistema().
    }

    public static ConfiguracionSistema getInstancia() {
        // 1. Comprobá con un if si instancia contiene null.
        if(instancia == null){
            instancia = new ConfiguracionSistema();
        }
        // 2. Dentro de ese if, creá un ConfiguracionSistema
        //    utilizando "new" y guardalo en el atributo instancia.

        //    Si ya existe, no debés crear otro objeto.

        // 3. Después del if, devolvé el atributo instancia.
        //    Reemplazá el return null que aparece debajo.
        //
        // El retorno debe quedar fuera del if para devolver
        // la instancia en todas las llamadas.
        return instancia;
    }

    public String getIdioma() {
        // Reemplazá el retorno de null por el valor
        // que tiene actualmente el atributo idioma.
        return idioma;
    }

    public void setIdioma(String idioma) {
        // Guardá el parámetro recibido en el atributo idioma.
        // Usá "this.idioma" para referirte al atributo del objeto.
        this.idioma = idioma;
        // Este método modifica la configuración existente;
        // no debe crear una nueva instancia.
    }
}
