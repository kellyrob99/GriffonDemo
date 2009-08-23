actions {
    action(id: "updateAction",
            name: "Click to update",
            closure: controller.updateText)
}
tabbedPane(tabGroup) {
    panel(title: "EDT Demo") {
        borderLayout()
        scrollPane(constraints: CENTER) {
            textArea(id: "editor", text: bind {model.text})
        }
        hbox(constraints: SOUTH) {
            button(updateAction)
        }
    }
}

