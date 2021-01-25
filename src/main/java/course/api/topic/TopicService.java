package course.api.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;
	
	private List<Topic> topics = new ArrayList<>( Arrays.asList(
			new Topic("1", "spring", "Springbot"),
			new Topic("2", "JSON", "JSON DESC")
			));
	
	public List<Topic> getAllTopics(){
		//return topics;
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(String id){
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return topicRepository.findById(id).orElse(null);

	}

	public void addTopic(Topic topic) {
		//topics.add(topic);
		topicRepository.save(topic);
	}

	public void updateTopic(Topic topic, String id) {
		// TODO Auto-generated method stub
		/*
		 * for(int i=0; i< topics.size(); i++) { Topic t = topics.get(i);
		 * if(t.getId().equals(id)) { topics.set(i, topic); } }
		 */
		topicRepository.save(topic);
	}

	public void deleteTopic(Topic topic, String id) {
		/*
		 * for(int i=0; i< topics.size(); i++) { Topic t = topics.get(i);
		 * if(t.getId().equals(id)) { topics.remove(i); } }
		 */
		topicRepository.deleteById(id);
	}
}
