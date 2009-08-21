application(title: 'GriffonDemo',
        //size:[320,480],
        pack: true,
        //location:[50,50],
        locationByPlatform: true,
        iconImage: imageIcon('/griffon-icon-48x48.png').image,
        iconImages: [imageIcon('/griffon-icon-48x48.png').image,
                imageIcon('/griffon-icon-32x32.png').image,
                imageIcon('/griffon-icon-16x16.png').image]
) {
  //any Swing view needs a layout
  flowLayout()

  // add content here
  label('This is the default view, which contains the root application definition.')

  button('click here to demo')

}