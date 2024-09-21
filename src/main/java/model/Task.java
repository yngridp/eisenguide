package model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tasks")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O Atributo título é obrigatório!")  //exclusivo para string, tipo not null
    @Size(min = 5, max = 100, message = "O atributo título deve ter no minímo 05 e no máximo 100 de caracteres.")
	private String titulo;

	@NotBlank(message = "O Atributo descrição é obrigatório!")  
    @Size(min = 5, max = 500, message = "O atributo texto deve ter no minímo 10 e no máximo 1000 de caracteres.")
	private String descricao;

	@Enumerated(EnumType.STRING)
	private TaskCategory categoria;

	@UpdateTimestamp //create data e hora da criaçao e update atualização data e hora da atualização
	private LocalDateTime data;

	private boolean isCompleted = false;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;
	
	    @ManyToOne // tipo de relacionamento tarefas, um para muitos
	    @JsonIgnoreProperties("tarefas")
	    private TaskCategory taskcategoria;  
	    
	    @ManyToOne 
	    @JsonIgnoreProperties("tarefas")
	    private Usuario usuario; 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TaskCategory getCategoria() {
		return categoria;
	}

	public void setCategoria(TaskCategory categoria) {
		this.categoria = categoria;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	


}


