class BindingDemoController {
    // these will be injected by Griffon
    def model
    def view

    void mvcGroupInit(Map args) {
        // this method is called after model and view are injected
    }

    def updateText = { evt = null ->
        println "calling updateText"
        doOutside{
            def myNewText = model.text
            doLater{
                view.mirrorLabel.text = myNewText
            }
        }
    }
}