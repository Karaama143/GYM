package Gym_management;


import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GymService {
    private final GymRepository repo;

    public GymService(GymRepository repo) {
        this.repo = repo;
    }

    public void insertGym(Gym gym){
        repo.save(gym);
    }
    public void updateGym(Gym gym){
        repo.save(gym);
    }
    public void deleteGym(Long id){
        repo.deleteById(id);
    }
    public Gym getGymById(Long id){
        return repo.findById(id).orElse(null);
    }
    public List<Gym> getAllGym(Long keyword){
        if(keyword != null)
            return repo.search(keyword);
        return repo.findAll();
    }
}
