package annotated;

import org.osoa.sca.annotations.Service;

@Service
public interface IDistSort
{
    String[] sort(String[] cadena);
}
