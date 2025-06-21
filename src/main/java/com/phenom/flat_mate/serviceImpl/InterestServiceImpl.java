package com.phenom.flat_mate.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phenom.flat_mate.entities.Interests;
import com.phenom.flat_mate.repository.InterestsRepo;
import com.phenom.flat_mate.services.InterestService;

@Service
public class InterestServiceImpl implements InterestService {

    @Autowired
    private InterestsRepo interestRepository;

    @Override
    public List<Interests> getAllInterests() {
        return interestRepository.findAll();
    }

    @Override
    public Interests updateInterest(long id, Interests updatedInterest) {
        Optional<Interests> optionalInterest = interestRepository.findById(id);
        if (optionalInterest.isPresent()) {
            Interests existing = optionalInterest.get();

            existing.setStatus(updatedInterest.getStatus());
            existing.setReasonForRejection(updatedInterest.getReasonForRejection());
            existing.setDateOfInterest(updatedInterest.getDateOfInterest());
            existing.setHouse(updatedInterest.getHouse());
            existing.setUser(updatedInterest.getUser());

            return interestRepository.save(existing);
        } else {
            throw new RuntimeException("Interest not found with id " + id);
        }
    }
}
