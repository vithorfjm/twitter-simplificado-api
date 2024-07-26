package twitter_simplificado.api.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import twitter_simplificado.api.DTOs.TweetCreateDTO;
import twitter_simplificado.api.DTOs.TweetDetailsDTO;
import twitter_simplificado.api.DTOs.TweetsListDTO;
import twitter_simplificado.api.domain.tweet.Tweet;
import twitter_simplificado.api.repositories.TweetRepository;


@RestController
@RequestMapping("tweets")
public class TweetController {

    @Autowired
    private TweetRepository repository;

    @GetMapping
    public ResponseEntity<Page<TweetsListDTO>> list(@PageableDefault(size = 10) Pageable pagination) {
        var page = repository.findAllByActiveTrue(pagination).map(TweetsListDTO::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id) {
        var tweet = repository.getReferenceById(id);
        return ResponseEntity.ok(new TweetDetailsDTO(tweet));
    }

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid TweetCreateDTO data, UriComponentsBuilder uriBuilder) {
        var tweet = new Tweet(data);
        repository.save(tweet);

        var uri = uriBuilder.path("/tweets/{id}").buildAndExpand(tweet.getId()).toUri();

        return ResponseEntity.created(uri).body(new TweetDetailsDTO(tweet));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        var tweet = repository.getReferenceById(id);
        tweet.excluir();
        return ResponseEntity.noContent().build();
    }

}
