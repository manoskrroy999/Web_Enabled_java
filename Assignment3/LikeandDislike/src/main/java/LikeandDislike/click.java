package LikeandDislike;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.faces.event.ActionEvent;
import java.io.Serializable;

@Named("clickBean")
@SessionScoped
public class click implements Serializable {

    private int likeCount = 0;
    private int dislikeCount = 0;

    public int getLikeCount() {
        return likeCount;
    }

    public int getDislikeCount() {
        return dislikeCount;
    }

    // Action Listener for Like
    public void like(ActionEvent event) {
        likeCount++;
    }

    // Action Listener for Dislike
    public void dislike(ActionEvent event) {
        dislikeCount++;
    }
}
