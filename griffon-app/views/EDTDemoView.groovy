import ca.odell.glazedlists.*
import ca.odell.glazedlists.gui.*
import ca.odell.glazedlists.swing.*

def createTableModel() {
    def columnNames = ["Title", "Categories", "Creator", "ClickCount", "CommentCount"]
    new EventTableModel(model.items, [
            getColumnCount: {columnNames.size()},
            getColumnName: {index -> columnNames[index]},
            getColumnValue: {object, index ->
                object."${columnNames[index].toLowerCase()}"
            }] as TableFormat)
}

actions {
    action(id: "updateAction",
            name: "Click to update",
            closure: controller.updateText)
}
tabbedPane(tabGroup) {
    panel(title: "EDT Demo") {
        borderLayout()
        label(id: "message", text: bind {model.text}, constraints:NORTH)
        scrollPane(constraints: CENTER) {
            table(id: "myTable", model: createTableModel())
        }
        new TableComparatorChooser(myTable,
                model.items, AbstractTableComparatorChooser.MULTIPLE_COLUMN_MOUSE)
        hbox(constraints: SOUTH) {
            button(updateAction)
            progressBar(id: "progress",
                    indeterminate: true,
                    minimum: 0, maximum: 100)
        }
    }
}


