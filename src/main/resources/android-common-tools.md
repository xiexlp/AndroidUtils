table
===
<table clas="table">
    <thead>
    <tr>
        <th>标题1</th>
        <th>标题2</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>内容1</td>
        <td>内容2</td>
    </tr>
    </tbody>
</table>

get
===
public void getNetWorkString(String url) {
        //String   url  = "https://192.168.191.1/boot/board/boards_json";//带https的网址
        final Request request = new Request.Builder().url(url).build();
        Call call = new HttpsCert().setCard(this).newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("数据取得失败");
                        //Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
                Log.i("joker", e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response)
                    throws IOException {
                final String res = response.body().string();
                Log.e("joker", res);
                System.out.println("收到的消息 具体的topic:" + res);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        //Toast.makeText(TopicListActivity.this, res, Toast.LENGTH_LONG).show();
                        final TopicDetailBean topicDetailBean = JSON.parseObject(res, TopicDetailBean.class);

                        System.out.println("topic title:"+topicDetailBean.getTitle());
                        System.out.println("topic content:"+topicDetailBean.getContent());
                        System.out.println("topic reply list size:"+topicDetailBean.getReplies());
                        //topicPageList = JSON.parseObject(res, PageList.class);
                        titleTextView.setText(topicDetailBean.getTitle());
                        contentTextView.setText(Html.fromHtml(topicDetailBean.getContent()));

                        contentTextView.setMovementMethod(LinkMovementMethod.getInstance());
                        usernameTextView.setText(topicDetailBean.getUsername());

                        //topic_title_text_view_toolbar.setText(topicDetailBean.getTitle());
                        //replyListBeans = topicDetailBean.getReplyList();

                        for(TopicDetailBean.ReplyListBean replyListBean:topicDetailBean.getReplyList()){
                            System.out.println("得到的回复:"+replyListBean.getContent());
                        }
                        replyListView = findViewById(R.id.topic_reply_list_view);
                        replyListBeanList = topicDetailBean.getReplyList();
                        myReplyAdapter = new MyReplyAdapter(TopicDetailActivity.this,replyListBeanList);
                        System.out.println("adapter 初始化成功");
                        replyListView.setAdapter(myReplyAdapter);
                        System.out.println("list view 配置好 adapter");
                        //监听动作
                        replyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                TopicDetailBean.ReplyListBean replyListBean = topicDetailBean.getReplyList().get(i);
                                System.out.println("reply list bean content:"+replyListBean.getContent());
                                Toast.makeText(TopicDetailActivity.this,replyListBean.getContent().toString(),Toast.LENGTH_LONG).show();
                            }
                        });

                        setListViewHeightBasedOnChildren(replyListView);
                        System.out.println("是否已经执行？？？");
                        //System.out.println("topic page list size:"+topicPageList.size());
                        //topicListView = findViewById(R.id.topic_list_view);
                        //topicListView.setAdapter(new TopicListActivity.TopicListAdapter(getParent()));

                        //Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                        //2). 通过intent携带额外数据
//                        String message = res;
//                        intent.putExtra("MESSAGE", message);
//                        //3). 启动Activity
//                        startActivity(intent);


                    }
                });
            }
        });
    }
    
post
===
public void postNetWorkString(String url,TopicDetailBean topicDetailBean) {
        //String   url  = "https://192.168.191.1/boot/board/boards_json";//带https的网址

        FormBody body = new FormBody.Builder()
                .add("title",topicDetailBean.getTitle())
                .add("content",topicDetailBean.getContent())
                .add("avatar",topicDetailBean.getAvatar())
                .add("userId",Integer.toString(topicDetailBean.getUserId()))
                .add("username",topicDetailBean.getUsername())
                .add("pwd","111111")
                .add("boardId",Integer.toString(topicDetailBean.getBoardId()))
                .add("langCode","zh-cn")
                .build();

        String sessionid= SpUtils.getSessionCookie(this,"sessionid");
        System.out.println("取出来的session id:"+sessionid);

        final Request request = new Request.Builder().url(url).post(body).addHeader("cookie",sessionid).build();


        Call call  = new HttpsCert().setCard(this).newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("数据取得失败");
                        //Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
                Log.i("joker", e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response)
                    throws IOException
            {
                final String res = response.body().string();
                Log.e("joker",res);
                System.out.println("收到的消息:"+res);
                System.out.println("增加主题成功");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("正常收到post消息");


                    }
                });
            }
        });
    }
