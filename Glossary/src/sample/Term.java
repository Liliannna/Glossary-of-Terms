package sample;

public class Term {
    private String term;
    private String description;

    public Term(String term, String description) {
        this.term = term;
        this.description = description;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Term term1 = (Term) o;

        if (term != null ? !term.equals(term1.term) : term1.term != null) return false;
        return description != null ? description.equals(term1.description) : term1.description == null;
    }

    @Override
    public int hashCode() {
        int result = term != null ? term.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}