class GriffonDemoController {
    // these will be injected by Griffon
    def model
    def view

    void mvcGroupInit(Map args) {
        // this method is called after model and view are injected
    }

    def launchTrident = {evt = null ->
         createNewTab ('TridentDemo')
    }

    def launchBinding = {evt = null ->
        createNewTab('BindingDemo')
    }

    def launchEdt = {evt = null ->
        createNewTab('EDTDemo')
    }
    
    private void createNewTab(mvcGroupName)
    {
        String mvcId = mvcGroupName + System.currentTimeMillis()
            createMVCGroup(mvcGroupName, mvcId,
                    [tabGroup: view.tabGroup, mvcId: mvcId])
    }
}