package sn.aziz.gestiondestockbackend.services;

import com.flickr4java.flickr.FlickrException;

import java.awt.im.InputSubset;
import java.io.InputStream;

public interface FlickrService {

    String savePhoto(InputStream photo, String title) throws FlickrException;
}
