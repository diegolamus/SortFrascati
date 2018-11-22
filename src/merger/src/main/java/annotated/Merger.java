package annotated;

import org.osoa.sca.annotations.Property;

public class Merger implements IDistSort
{
    public Merger()
    {
        System.out.println("MERGER created.");
    }

    public final String[] sort(final String[] cadenas)
    {
		System.out.println("MERGER called.");
		// TODO create merger strategy
		return null;
    }

}
