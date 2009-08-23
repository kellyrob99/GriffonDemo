actions {
    action(id: "updateAction",
            name: "Click to update",
            closure: controller.updateText)
}
tabbedPane(tabGroup) {
    panel(title: "Binding Demo", name: 'bindingPanel') {
        borderLayout()
        panel(constraints: NORTH, preferredSize: [320, 100]) {
            label('Enter text and click button to update.')
            textField(id: 'bindingField', name: 'bindingField',columns: 20)
        }
        //link the model and the textField
        bean(model, text: bind { bindingField.text })
        panel {
            borderLayout()
            //link the label text with the model
            label(name: 'bindingLabel', text: bind {model.text}, constraints: NORTH)
            separator()
            label(id: 'mirrorLabel', name: 'mirrorLabel', text: 'Click the button to sync me!', constraints: SOUTH)
        }
        button(updateAction, name:'updateButton', constraints: SOUTH)
    }
}

