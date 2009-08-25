class BindingDemoController {
    // these will be injected by Griffon
    def model
    def view

    void mvcGroupInit(Map args) {
        // this method is called after model and view are injected
    }

    /**
     * Update the text on a UI component using dsl for SwingUtilities
     */
    def updateText = { evt = null ->
        doOutside{
            def myNewText = model.text
            doLater{
                view.mirrorLabel.text = myNewText
            }
        }
    }
}