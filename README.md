## Тестовое задание VK

##### Необходимо реализовать rest api с использованием любого известного вам фреймворка или библиотеки на Java >=17.

### Результат
Были созданы защищенные обработчики запросов к jsonplaceholder, доступные пользователям с необходимыми ролями и. Авторизация и аутенфикация происходит с помощью basic auth
- /api/posts - ROLE_POSTS
- /api/users - ROLE_USERS
- /api/albums - ROLE_ALBUMS
  Также пользователям с ролью ROLE_ADMIN доступны запросы на все вышеперечисленные пути.

Для получения данных из jsonplaceholder используются созданные клиенты FeignClient, которые выполняют нужные запросы. Пример FeignClient, который совершает обработку запросов. Набор параметров, поддерживаемый jsonplaceholder, также доступен в созданных контроллерах и передает параметры в запрос к jsonplaceholder:

```java
@FeignClient(url = "https://jsonplaceholder.typicode.com/albums/",name="albums")
@CacheConfig(cacheNames={"albums"})
public interface AlbumsClient {

  @GetMapping
  @Cacheable
  List<Album> getAlbums(@SpringQueryMap Map<String,Object> params);

  @GetMapping("{albumId}")
  @Cacheable
  Album getAlbum(@PathVariable Integer albumId);
```

Запросы к jsonplaceholder кэшируются с помощью spring-cache и аннотации @Cacheble. В application.yml установлено время жизни кэша - 1 минута. По истечении этого времени запрос будет снова (данные актуальны в пределах 1 минуты).

В приложении ведется аудит действий пользователя, который сохраняет информацию о действиях (имя пользователя, роли, URI, метод запроса, имеет ли доступ, параметры запроса) в базу данных и выводит в логи.

Для хранения данных о пользователях также используется  база данных. При запуске приложения создается 4 пользователя с логином-паролем post-post, user-user, album-album, admin-admin. Но также пользователям с ролью ROLE_ADMIN доступен endpoint /api/user-details для создания нового пользователя с необходимыми ролями доступа.

```java
@Entity
@Table(name = "user_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserDetailsImpl implements UserDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String username;
  private String password;
  @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
  @CollectionTable(name = "user_role",
          joinColumns = @JoinColumn(name = "user_id"))
  @Enumerated(EnumType.STRING)
  private Set<Role> roles = new HashSet<>();
```
