package br.com.jsn.desafio.util;


import br.com.jsn.desafio.dto.ProjetoDto;
import br.com.jsn.desafio.entity.Projeto;

public abstract class DtoUtil {


    public static Projeto dtoParaEntidade(ProjetoDto dto){

        Projeto projeto = new Projeto();
        if(dto.getId() != null){
            projeto.setId(dto.getId());
        }
        projeto.setData(DateUtil.formatarStringParaDate(dto.getData()));
        projeto.setDescricao(dto.getDescricao());
        projeto.setTitulo(dto.getTitulo());
        projeto.setUsuario(dto.getUsuario());
        return projeto ;
    }

    public static ProjetoDto entidadeParaDto(Projeto entidade){

        ProjetoDto projetoDto = new ProjetoDto();

        projetoDto.setData(DateUtil.formatarDateParaString(entidade.getData()));
        projetoDto.setDescricao(entidade.getDescricao());
        projetoDto.setId(entidade.getId());
        projetoDto.setTitulo(entidade.getTitulo());
        projetoDto.setUsuario(entidade.getUsuario());
        return projetoDto ;
    }
    
}
