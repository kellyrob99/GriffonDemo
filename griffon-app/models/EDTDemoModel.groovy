import groovy.beans.Bindable
import ca.odell.glazedlists.EventList
import ca.odell.glazedlists.SortedList
import ca.odell.glazedlists.BasicEventList

class EDTDemoModel {
    def columnNames = ["Title", "Categories", "Creator", "ClickCount", "CommentCount"]

    @Bindable String text

    EventList items = new SortedList(new BasicEventList(), null)
}