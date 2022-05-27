import java.io.FileNotFoundException;
import java.util.List;

public interface characterLoaderInterface {
  public List<CharacterInterface> getFile(String path) throws FileNotFoundException;
}
