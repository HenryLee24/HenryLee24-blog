# ローカルのファイルをGithubのリモートリポジトリへプッシュする方法

1. ファイルを作成する
2. Githubで新しいリモートリポジトリを作成する

![image-20230502094341163](C:\HenryLee24-blog\Git\assets\Githubで新しいリモートリポジトリを作成.png)

3. VS Codeでファイルを開く

ファイルの名前は絶対リモートリポジトリの名前と同じにする。

![image-20230502094538464](C:\HenryLee24-blog\Git\assets\VS Codeでファイルを開く.png)

4. Quick setupを参照する

![image-20230502094859373](C:\HenryLee24-blog\Git\assets\Quick setupを参照する.png)



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

![image-20230502095229702](C:\HenryLee24-blog\Git\assets\VSCodeでaddとcommit.png)

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

![image-20230502092251989](C:\HenryLee24-blog\Git\assets\古い資格情報が残った.png)

6. SSH認証の鍵を作成する

[オフィシャルURL]: https://docs.github.com/ja/authentication/connecting-to-github-with-ssh/generating-a-new-ssh-key-and-adding-it-to-the-ssh-agent

がある。

```
ssh-keygen -t ed25519 -C "hench.listudy@gmail.com"
```



PS: これ以上操作の結果

![image-20230502101629557](C:\HenryLee24-blog\Git\assets\これ以上操作の結果.png)



7. SSHの公開鍵をGitHubに貼り付ける

貼り付けるコマンド

```
clip < ~/.ssh/id_ed25519.pub
```



貼り付けるところ

![image-20230502101829294](C:\HenryLee24-blog\Git\assets\貼り付けるところ.png)

8. SSHを認証する

```
ssh -T git@github.com
```

![image-20230502102228182](C:\HenryLee24-blog\Git\assets\SSHを認証する.png)

ところが、秘密鍵はここに保存されている。

![image-20230502102442762](C:\HenryLee24-blog\Git\assets\秘密鍵はここに保存されている.png)

