package autocomplete;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Binary search implementation of the {@link Autocomplete} interface.
 *
 * @see Autocomplete
 */
public class BinarySearchAutocomplete implements Autocomplete {
    /**
     * {@link List} of added autocompletion terms.
     */
    private final List<CharSequence> terms;

    /**
     * Constructs an empty instance.
     */
    public BinarySearchAutocomplete() {
        this.terms = new ArrayList<>();
    }

    @Override
    public void addAll(Collection<? extends CharSequence> terms) {
        // TODO: Replace with your code
        this.terms.addAll(terms);
        Collections.sort(this.terms, CharSequence::compare);
    }

    @Override
    public List<CharSequence> allMatches(CharSequence prefix) {
        // TODO: Replace with your code
        List<CharSequence> returnList = new ArrayList<>();
        int index = Collections.binarySearch(this.terms, prefix, CharSequence::compare); //find start index
        int start = index;
        if(index < 0) {
            start = -index - 1;
        }
        for(int i = start; i < terms.size(); i++){
            if(Autocomplete.isPrefixOf(prefix, terms.get(i))){
                returnList.add(terms.get(i));
            }
        }
        return returnList;
    }
}
