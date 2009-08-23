class GriffonDemoController {
    // these will be injected by Griffon
    def model
    def view

    void mvcGroupInit(Map args) {
        // this method is called after model and view are injected
    }


    def launchTrident = {evt = null ->
         createNewTab ('TridentDemo', 'TridentDemo'+System.currentTimeMillis())
    }

    def launchBinding = {evt = null ->
        createNewTab('BindingDemo', 'BindingDemo'+System.currentTimeMillis())
    }

    def launchEdt = {evt = null ->
        createNewTab('EDTDemo', 'EDTDemo'+System.currentTimeMillis())        
    }
    
    private void createNewTab(mvcGroupName, mvcId)
    {
            createMVCGroup(mvcGroupName, mvcId,
                    [tabGroup: view.tabGroup, mvcId: mvcId])
    }
}