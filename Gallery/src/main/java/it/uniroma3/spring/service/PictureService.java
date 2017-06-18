package it.uniroma3.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.spring.model.Author;
import it.uniroma3.spring.model.Picture;
import it.uniroma3.spring.repository.PictureRepository;

@Service
public class PictureService {

    @Autowired
    private PictureRepository pictureRepository; 

    public Iterable<Picture> findAll() {
        return this.pictureRepository.findAll();
    }

    @Transactional
    public void add(final Picture picture) {
        this.pictureRepository.save(picture);
    }
    
    public void remove(final Long pictureId) {
        this.pictureRepository.delete(pictureId);
    }

	public Picture findbyId(Long id) {
		return this.pictureRepository.findOne(id);
	}
	
	public Iterable<Picture> findByAuthor(Author a) {
        return this.pictureRepository.findByAuthor(a);
    }

}
