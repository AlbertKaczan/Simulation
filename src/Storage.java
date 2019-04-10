import java.io.Serializable;
import java.util.List;

public class Storage implements Serializable {
    public List<Planet> planets;

    public Storage(List<Planet> planets) {
        this.planets = planets;
    }
}
