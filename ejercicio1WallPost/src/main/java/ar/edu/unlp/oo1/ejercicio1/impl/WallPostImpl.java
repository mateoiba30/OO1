package ar.edu.unlp.oo1.ejercicio1.impl;

import ar.edu.unlp.oo1.ejercicio1.WallPost;


public class WallPostImpl implements WallPost {

	private String text;
	private int likes;
	private boolean featured; //marcado
	
	public WallPostImpl() {//es un constructor, no hace falta indicar lo  que devuelve
		this.text="Undefined post"; //no es necesario usar las funciones de set, para esta misma clase las variables no son privadas
		this.likes=0;
		this.featured=false;
	}

    @Override
    public String toString() {
        return "WallPost {" +
            "text: " + getText() +
            ", likes: '" + getLikes() + "'" +
            ", featured: '" + isFeatured() + "'" +
            "}";       
    }

    public String getText() {
    	return this.text;
    }

    public void setText (String descripcionText) {
    	this.text = descripcionText; //ambas variables apuntan al mismo objeto string, pero no son el mismo objeto (son 2 objetos diferentes conel mismo contenido) 
    }
    
    public int getLikes() {
    	return this.likes;
    }
    
    public void like() {
    	this.likes++;
    }

    public void dislike() {
    	if (this.likes > 0)
    		this.likes --;
    }
    
    public boolean isFeatured() {
    	return this.featured;
    }
    
    public void toggleFeatured() {
    	if (this.featured == false)
    		this.featured = true;
    	else
    		this.featured = false;
    }
}
