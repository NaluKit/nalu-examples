package com.github.nalukit.example.nalu.simpleapplication.client.ui;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface ImageResources
    extends ClientBundle {

  ImageResources IMAGES = GWT.create(ImageResources.class);

  @Source("bug.png")
  ImageResource bug();

}
