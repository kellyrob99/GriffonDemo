application {
    title='GriffonDemo'
    startupGroups = ['GriffonDemo']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "EDTDemo"
    'EDTDemo' {
        model = 'EDTDemoModel'
        view = 'EDTDemoView'
        controller = 'EDTDemoController'
    }

    // MVC Group for "BindingDemo"
    'BindingDemo' {
        model = 'BindingDemoModel'
        view = 'BindingDemoView'
        controller = 'BindingDemoController'
    }

    // MVC Group for ""
    'TridentDemo' {
        model = 'TridentDemoModel'
        view = 'TridentDemoView'
        controller = 'TridentDemoController'
    }

    // MVC Group for "GriffonDemo"
    'GriffonDemo' {
        model = 'GriffonDemoModel'
        view = 'GriffonDemoView'
        controller = 'GriffonDemoController'
    }

}
