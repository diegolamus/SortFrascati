package annotated;

import org.osoa.sca.annotations.Property;
import org.osoa.sca.annotations.Reference;

public class Merger implements IDistSort
{
	// Monolitico
	@Reference(name = "sorter1")
	private IDistSort sorter1;

    public Merger()
    {
        System.out.println("MERGER created.");
    }

    public final String[] sort(final String[] cadenas)
    {
		System.out.println("MERGER called.");
		// monolítico
		String[] sorted = sorter1.sort(cadenas);			
		return sorted;
    }

}
