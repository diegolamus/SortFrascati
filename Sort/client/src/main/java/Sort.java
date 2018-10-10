import org.osoa.sca.annotations.Service;

@Service
public interface Sort
{
    String[] sort(String[] strings);
}
