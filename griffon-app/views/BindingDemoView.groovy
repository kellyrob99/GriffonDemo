import java.awt.Font

actions {
    action(id: "updateAction",
            name: "Click to update",
            closure: controller.updateText)
}

def myFont = new Font('Helvetica',Font.BOLD, 24)

tabbedPane(tabGroup) {
    panel(title: "Binding Demo", name: 'bindingPanel') {
        borderLayout()
        panel(constraints: NORTH, preferredSize: [320, 100]) {
            label('Enter text and click button to update.', font:myFont)
            textField(id: 'bindingField', name: 'bindingField',columns: 20, font:myFont)
        }

        //link the model and the textField
        bean(model, text: bind { bindingField.text })
        
        panel(background: color('white')) {
            borderLayout()
            //link the label text with the model
            label(name: 'bindingLabel', text: bind {model.text}, font:myFont, constraints: NORTH)
            separator()
            label(id: 'mirrorLabel', name: 'mirrorLabel', text: 'Click the button to sync me!', font:myFont, constraints: CENTER)
        }
        button(updateAction, name:'updateButton', constraints: SOUTH)
    }
}

