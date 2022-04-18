package com.foonk.spring.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public final class CompanyReadDto {
    private final Integer id;
    private final String name;

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof CompanyReadDto)) return false;
        final CompanyReadDto other = (CompanyReadDto) o;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        return result;
    }

    public String toString() {
        return "CompanyReadDto(id=" + this.getId() + ", name=" + this.getName() + ")";
    }
}
