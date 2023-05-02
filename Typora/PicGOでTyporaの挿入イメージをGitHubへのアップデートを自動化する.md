# スピードなブログ投稿：PicGOでTyporaの挿入イメージをGitHubへのアップデートを自動化する

## 背景

Githubはブログとして使いたい。

手順：ローカルで書いたMarkdownノートをGithubのパブリックレポジトリへプッシュすることで、文章を発行する。

#### 作成した後に驚いた補足

ローカル作成した文章をGitHubの個人アカウントにホスティングだけでなく、MarkdownのソースコードをQittaにそのままコピペすると、一秒で投稿できる！

この機能はQittaにある事実がよくわかるが（更にブログ作成のため一番重要な編集機能を思う）、Qittaの文章を何回も編集してから、スパムアカウントと見られ、使えなくなるよ。

つまり、たくさんで複数回のコミットはGitとGithubに任せるのがいいな。

![image-20230502134708743](https://raw.githubusercontent.com/HenryLee24/figure/main/image-20230502134708743.png)


## 問題

ローカルのイメージとリモートレポジトリのイメージを同時に表示できない。

##### ローカル：よし、リモート：だめ

![image-20230502123350402](https://raw.githubusercontent.com/HenryLee24/figure/main/image-20230502123350402.png)

##### ローカル：だめ、リモート：よし

URLの置換が必要。（日本語システムの \ はけっこうめんどくさいな）

![image-20230502123517400](https://raw.githubusercontent.com/HenryLee24/figure/main/image-20230502123517400.png)

次は効果。

![image-20230502124353729](https://raw.githubusercontent.com/HenryLee24/figure/main/image-20230502124353729.png)

つまり、同時に表示できない。

## 解決策

PicGo+Typora

##### 名詞解説

PicGoとはImageHostを自動的に作成、アップデートするサービスを提供している無料ソフトウェア。

ImageHostというものはイメージをネットで格納する場所。



残念だが、PicGoは中国語とEnglish両方しかサポートしていない。こちらは中国語の設置方法を紹介する。Englishに切り替える方法は以下になる。

![image-20230502135954730](https://raw.githubusercontent.com/HenryLee24/figure/main/image-20230502135954730.png)



Typoraは人気なMarkdown編集ソフトウェア。

##### どのように解決する

Typoraの中に、PicGoを連携しながら、イメージをmdに挿入したところ自動的にGithubのレポジトリへアップロードし、ローカルとウェブサイトの際両方同時に表示するのが可能。

1. Picoをダウンロードする

[ダウンロードURL入口]: https://picgo.github.io/PicGo-Doc/en/guide/#instruction

![image-20230502125946613](https://raw.githubusercontent.com/HenryLee24/figure/main/image-20230502125946613.png)

Github Release



![image-20230502130012780](https://raw.githubusercontent.com/HenryLee24/figure/main/image-20230502130012780.png)

2.3.1というバージョンコードをクリックする



![image-20230502130117603](https://raw.githubusercontent.com/HenryLee24/figure/main/image-20230502130117603.png)

下にスクロールして、インストールファイルを見つけた

2. インストールする

もし問題がなれけば、ここにアイコンが出る。

![image-20230502130332385](https://raw.githubusercontent.com/HenryLee24/figure/main/image-20230502130332385.png)



クリックして、この画面が出る

![image-20230502130349228](https://raw.githubusercontent.com/HenryLee24/figure/main/image-20230502130349228.png)

3. 設置する

まずは「图床设置」の下にGithubを選択する

![image-20230502130449057](https://raw.githubusercontent.com/HenryLee24/figure/main/image-20230502130449057.png)

これから設置しよう。

「设定仓库名」：GithubユーザーID/figure（補足：自分のGithubに、figureというpublicリポジトリを作成しておく）

「设定分支名」：main

「设定Token」：ここに生成したトーコンを貼り付ける（補足：Settings-developer settings-Personal access token-generate new token、そしてselect scopesのところはrepoという権限をしか与えない、最後はGenerate token。生成したトーコンは一回しか表示しないので保存しておくのほうが賢い）

「确定」をクリックすると、設置完了。

4. Picoをテストする

任意のイメージを「上传区」にドラッグ＆ドロップして、figureにイメージがあるかとうかをテストしよう。

![image-20230502131836244](https://raw.githubusercontent.com/HenryLee24/figure/main/image-20230502131836244.png)

5. Typoraの設定

![image-20230502132005091](https://raw.githubusercontent.com/HenryLee24/figure/main/image-20230502132005091.png)

まずは設定。



![image-20230502132047879](https://raw.githubusercontent.com/HenryLee24/figure/main/image-20230502132047879.png)

そして、ポイントはいくつある。

- When InsertはUpload imageになる。

- 青いクリック
- Image UploaderはPicGo(app)を選択する。



ここまで、設定は完了になります。

Typoraでイメージを挿入してみようか～