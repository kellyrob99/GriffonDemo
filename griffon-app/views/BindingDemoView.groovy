actions {
    action(id: "updateAction",
            name: "Click to update",
            closure: controller.updateText)
}
tabbedPane(tabGroup) {
    panel(title: "Binding Demo") {
        borderLayout()
        panel(constraints: NORTH, preferredSize: [320, 100]) {
            label('Enter text and click button to update.')
            textField(id: 'bindingField', columns: 20)
        }
        //link the model and the textField
        bean(model, text: bind { bindingField.text })
        panel {
            borderLayout()
            //link the label text with the model
            label(text: bind {model.text}, constraints: NORTH)
            separator()
            label(id: 'mirrorLabel', text: 'Click the button to sync me!', constraints: SOUTH)
        }
        button(updateAction, constraints: SOUTH)
    }
}

