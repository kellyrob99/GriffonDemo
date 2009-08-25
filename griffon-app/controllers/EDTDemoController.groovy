class EDTDemoController {
    // these will be injected by Griffon
    def model
    def view

    def url = 'http://www.dzone.com/links/feed/frontpage/rss.xml'
    def completionMessage = 'Update Complete'

    void mvcGroupInit(Map args) {
        // this method is called after model and view are injected
    }

    /**
     * Load the Dzone RSS Feed off of the EDT, update on the EDT and update progress using SwingWorker
     */
    def updateText = {evt = null ->
        jxwithWorker(start: true) {
            onInit {
                view.progress.with {
                    setIndeterminate(false)
                    setStringPainted(true)
                    setString("0 %")
                }
            }
            work {
                //parse the feed
                def feed = new XmlSlurper().parse(url).declareNamespace(dc: 'http://purl.org/dc/elements/1.1/',
                        dz: 'http://www.developerzone.com/modules/dz/1.0')

                //reference used to calculate progress
                def count = feed.channel.item.size()

                feed.channel.item.eachWithIndex {item, index ->
                    //add to the list on the EDT
                    edt {
                        model.items << [title: item.title.text(), categories: item.category.list().collect {it.text()}.join(','),
                                creator: item.'dc:creator'.text(), clickcount: item.'dz:clickCount'.text(), commentcount: item.'dz:commentCount'.text()]
                    }
                    //Thread.sleep(200)
                    publish(((index / count) * 100) as int)
                }
                completionMessage    
            }
            onUpdate {chunks ->
                view.progress.string = chunks[0] + " %"
                view.progress.value = chunks[0]
            }
            onDone {
                model.text = get()
                view.progress.stringPainted = false
                view.progress.indeterminate = true
            }
        }
    }
}