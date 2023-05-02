Gitのグローバル設定をローカルで変更して、関連しているGithubアカウントを変更する場合は、次の手順に従います。

1. Git Bashを開きます。

2. 次のコマンドを入力して、現在のGitのグローバル設定を表示します。

```
git config --global user.name
git config --global user.email
```

実際の効果

![image-20230502070212571](C:\HenryLee24-blog\Git\assets\image-20230502070212571.png)

3. 今回は古いアカウントから新しアカウントに切り替えます。変更方法は次のように変更します。

```
git config --global user.name "your new username"
git config --global user.email "your new email"
```

変更を行った後、新しい設定が適用されたことを確認できます。

実際の効果

![キャプチャ](C:\HenryLee24-blog\Git\assets\キャプチャ.PNG)