
* HTMLでフォームクラスのオブジェクトを使う場合、コントローラーの引数にクラスを指定しておきます。

```java
@GetMapping("/form")
public String showForm(PersonForm personForm){
    return "form";
}
```

* HTMLではth:objectにフォームクラスのオブジェクトを指定して、inputフィールドとクラスのフィールドは、
* ht:field="*{name}"のような形で指定しておきます。
* \#fields.hasErrors("フィールド名")でエラーの有無を真偽値で取得できます
  * th:errors="*{フィールド名}"でフィールドのエラーメッセージを表示する

___

* 引数で@Validアノテーションを付けることでフォームクラスでついたバリデーションを実施します
* 詳細記事にあるように相関チェックを行う場合でもアノテーションをつけます。
* エラーがあればBindingResultにエラーが格納されます。

```java
@PostMapping("/form")
public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult){
    if(bindingResult.hasErrors()){
        return "form";
    }
    return "redirect:/results";
}
```

[詳細記事](https://volkruss.com/?p=2083)