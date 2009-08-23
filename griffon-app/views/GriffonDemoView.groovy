import javax.swing.JTabbedPane

actions {
    action(id: "launchDemo1",
            name: "Graphics and Animation",
            closure: controller.launchTrident)
    action(id: "launchDemo2",
            name: "Binding",
            closure: controller.launchBinding)
    action(id: "launchDemo3",
            name: "Launch",
            closure: controller.launchEdt)
}

myapp = application(title: 'GriffonDemo',
        size: [320, 480],
        locationByPlatform: true,
        iconImage: imageIcon('/griffon-icon-48x48.png').image,
        iconImages: [imageIcon('/griffon-icon-48x48.png').image,
                imageIcon('/griffon-icon-32x32.png').image,
                imageIcon('/griffon-icon-16x16.png').image]
) {

    menuBar {
        menu("Demo") {
            menuItem(launchDemo1)
            menuItem(launchDemo2)
            menuItem(launchDemo3)
        }
    }
    //any Swing view needs a layout
    borderLayout()
    tabbedPane(id: 'tabGroup', constraints: CENTER)
}