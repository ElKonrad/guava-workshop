package base;

import com.google.common.base.Preconditions;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Group {
    private String name;

    public void updateGroupName(String name) {
        Preconditions.checkNotNull(name, "Group name cannot be null");
        Preconditions.checkArgument(name.length() < 3, "Group name cannot be longer than 3 characters");
        this.name = name;
    }
}
