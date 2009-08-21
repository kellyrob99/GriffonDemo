import java.awt.BorderLayout

class GriffonDemoController {
    // these will be injected by Griffon
    def model
    def view

    void mvcGroupInit(Map args) {
        // this method is called after model and view are injected
    }

    def switchLayout = { evt = null ->
      println "hit the method call with $evt"
        model.layout = new BorderLayout()
       view.mainPanel.setLayout(model.layout)
    }
}