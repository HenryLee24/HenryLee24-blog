# ローカルのファイルをGithubのリモートリポジトリへプッシュする方法

1. ファイルを作成する
2. Githubで新しいリモートリポジトリを作成する

![github-de-atarashii-repo-sakusei](https://raw.githubusercontent.com/HenryLee24/figure/main/github-de-atarashii-repo-sakusei.png)



3. VS Codeでファイルを開く

ファイルの名前は絶対リモートリポジトリの名前と同じにする。

![VSCodeでファイルを開く](https://raw.githubusercontent.com/HenryLee24/figure/main/VSCode%E3%81%A7%E3%83%95%E3%82%A1%E3%82%A4%E3%83%AB%E3%82%92%E9%96%8B%E3%81%8F.png)

4. Gitアカウントを変更する

表示する

```
git config --global user.name
git config --global user.email
```

変更する

```
git config --global user.name "HenryLee24"
git config --global user.email "hench.listudy@gmail.com"	
```

4. Quick setupを参照する

![Quick-setupを参照する](https://raw.githubusercontent.com/HenryLee24/figure/main/Quick-setup%E3%82%92%E5%8F%82%E7%85%A7%E3%81%99%E3%82%8B.png)

```
echo "# HenryLee24-blog" >> README.md
git init
git add ...
git commit -m "first commit"　（VSCodeでaddとcommit）
git branch -M main
git remote add origin https://github.com/HenryLee24/HenryLee24-blog.git
（ここまで）
git push -u origin main
```

![VSCode-de-add-to-commit](https://raw.githubusercontent.com/HenryLee24/figure/main/VSCode-de-add-to-commit.png)

5. リモートリポジトリへプッシュする（問題発生）

エラーメッセージ

```
h-li24@DESKTOP-0MLIPP3 MINGW64 /c/Coding/HenryLee24-blog (main)
$ git push -u origin main
remote: Support for password authentication was removed on August 13, 2021.
remote: Please see https://docs.github.com/en/get-started/getting-started-with-git/about-remote-repositories#cloning-with-https-urls for information on currently recommended modes of authentication.
fatal: Authentication failed for 'https://github.com/HenryLee24/HenryLee24-blog.git/'
```

原因

古い資格情報が残った。

そして、これはhttps認証で、今はtokensを使って認証を行えるが、ここはssh認証でリモートリポジトリへ通信したいので、この資格情報を削除する。

![古い資格情報が残った](https://raw.githubusercontent.com/HenryLee24/figure/main/%E5%8F%A4%E3%81%84%E8%B3%87%E6%A0%BC%E6%83%85%E5%A0%B1%E3%81%8C%E6%AE%8B%E3%81%A3%E3%81%9F.png)

6. SSH認証の鍵を作成する

[オフィシャルURL]: https://docs.github.com/ja/authentication/connecting-to-github-with-ssh/generating-a-new-ssh-key-and-adding-it-to-the-ssh-agent

がある。

```
ssh-keygen -t ed25519 -C "hench.listudy@gmail.com"
```



PS: これ以上操作の結果

![これ以上操作の結果](https://raw.githubusercontent.com/HenryLee24/figure/main/%E3%81%93%E3%82%8C%E4%BB%A5%E4%B8%8A%E6%93%8D%E4%BD%9C%E3%81%AE%E7%B5%90%E6%9E%9C.png)



7. SSHの公開鍵をGitHubに貼り付ける

貼り付けるコマンド

```
clip < ~/.ssh/id_ed25519.pub
```



貼り付けるところ

![area of copy and paste](https://raw.githubusercontent.com/HenryLee24/figure/main/area%20of%20copy%20and%20paste.png)

8. SSHを認証する

```
ssh -T git@github.com
```

![SSHを認証する](https://raw.githubusercontent.com/HenryLee24/figure/main/SSH%E3%82%92%E8%AA%8D%E8%A8%BC%E3%81%99%E3%82%8B.png)

ところが、秘密鍵はここに保存されている。



![private key is stored in here](https://raw.githubusercontent.com/HenryLee24/figure/main/private%20key%20is%20stored%20in%20here.png)



9. リモートリポジトリへプッシュする（本番）

```
git push -u origin main
```

これは認証成功のシンボル。

![これは認証成功のシンボル](https://raw.githubusercontent.com/HenryLee24/figure/main/%E3%81%93%E3%82%8C%E3%81%AF%E8%AA%8D%E8%A8%BC%E6%88%90%E5%8A%9F%E3%81%AE%E3%82%B7%E3%83%B3%E3%83%9C%E3%83%AB.png)

この操作で、ローカルのGitとリモートのGitHubは繋がる。

![ローカルのGitとリモートのGitHubは繋がる](https://raw.githubusercontent.com/HenryLee24/figure/main/%E3%83%AD%E3%83%BC%E3%82%AB%E3%83%AB%E3%81%AEGit%E3%81%A8%E3%83%AA%E3%83%A2%E3%83%BC%E3%83%88%E3%81%AEGitHub%E3%81%AF%E7%B9%8B%E3%81%8C%E3%82%8B.png)

そのアクセス権限はあげると、プッシュ操作も完了になる。

![プッシュ操作も完了になる](https://raw.githubusercontent.com/HenryLee24/figure/main/%E3%83%97%E3%83%83%E3%82%B7%E3%83%A5%E6%93%8D%E4%BD%9C%E3%82%82%E5%AE%8C%E4%BA%86%E3%81%AB%E3%81%AA%E3%82%8B.png)

最終的に、ローカルのファイルをGitHubのリモートリポジトリへプッシュした。

![プッシュした](https://raw.githubusercontent.com/HenryLee24/figure/main/%E3%83%97%E3%83%83%E3%82%B7%E3%83%A5%E3%81%97%E3%81%9F.png)