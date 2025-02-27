package com.example.itqan2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.itqan2.adapters.PostAdapter
import com.example.itqan2.models.MediaType
import com.example.itqan2.models.Post

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val posts = listOf(
            Post(1, "سُورَةُ الأَحۡزَابِ", "\n" +
                    "آيَـــــــــــاتُــــهَا :\n" +
                    "ثَلاثٌ وَسَبْعُونَ (73).\n" +
                    "2\n" +
                    "مَعنَى اسْـــمِها :\n" +
                    "الأَحْزَابُ: جَمْعُ حِزْبِ، وَهُمُ: الطَوائِفُ مِنَ النَّاسِ، وَالمُرَادُ (بِالأَحْزَابِ): غَزْوَةُ الأَحْزَابِ عَامَ (5هـ).\n" +
                    "3\n" +
                    "سَبَبُ تَسْمِيَتِها :\n" +
                    "انْفِرَادُ السُّورَةِ بِذِكْرِ أَحْدَاثِ غَزْوَةِ (الْأَحْزَابِ)، وَدِلَالَةُ هَذَا الاسْمِ عَلَى الْمَقْصِدِ الْعَامِّ لِلسُّورَةِ وَمَوضُوعَاتِهَا.\n" +
                    "4\n" +
                    "أَسْــــــمَاؤُهــا :\n" +
                    "لا يُعرَفُ للسُّورَةِ اسمٌ آخَرُ سِوَى سُورَةِ (الْأَحْزَابِ).\n" +
                    "5\n" +
                    "مَقْصِدُها العَامُّ :\n" +
                    "بَيَانُ فَضْلِ النَّبِيِّ \uF072 وَأَهْلِ بَيْتِهِ، وَكَشْـفُ أَهْلِ النِّفَاقِ وَالْكُفْرِ فِي أَذِيَّتِهِ \uF072 وأَذِيَّةِ المُؤْمِنِينَ.\n" +
                    "6\n" +
                    "سَبَبُ نُــزُولِهَـا :\n" +
                    "سُورَةٌ مَدَنيَّةٌ، لَمْ يُنقَل سَبَبٌ لِنـُزُوْلِهَا جُملَةً وَاحِدَةً، ولكِن صَحَّ لِبَعضِ آياتِهَا سَبَبُ نُزُولٍ.\n" +
                    "7\n" +
                    "فَضْـــــــــــلُـهـا :\n" +
                    "لَم يَصِحَّ حَدِيثٌ أَو أَثَرٌ خَاصٌّ فِي فَضْلِ السُّورَةِ، سِوَى أَنـَّهَا مِنَ المَثَانِي.\n" +
                    "8\n" +
                    "مُنَــاسَـــبَاتُــها :\n" +
                    "مُنَاسَبَةُ أَوَّلِ سُورَةِ (الْأَحْزَابِ) بِآخِرِهَا: التَّحْذِيرُ مِنْ طَاعَةِ الكَافِرِينَ وَالْمُنَافِقِينَ وَبَيَانُ عَاقِبَتِهِم، فقَالَ فِي فَاتِحَتِهَا: \uF05Dيَٰٓأَيُّهَا ٱلنَّبِيُّ ٱتَّقِ ٱللَّهَ وَلَا تُطِعِ ٱلۡكَٰفِرِينَ وَٱلۡمُنَٰفِقِينَۚ …١\uF05B. وَقَالَ فِي خَاتِمَتِهَا: \uF05Dلِّيُعَذِّبَ ٱللَّهُ ٱلۡمُنَٰفِقِينَ وَٱلۡمُنَٰفِقَٰتِ وَٱلۡمُشۡرِكِينَ وَٱلۡمُشۡرِكَٰتِ …٧٣\uF05B.\n" +
                    "مُنَاسَبَةُ سُورَةِ (الْأَحْزَاب) لِمَا قَبلَهَا مِنْ سُورَةِ (السَّجْدَةِ):\n" +
                    "خُتِمَتِ (السَّجْدةُ) بِتَوجِيهِ النَّبِيِّ \uF072 بِالإِعْرَاضِ عَنْ الكَافِرِينَ؛ فَقَالَ: \uF05Dفَأَعۡرِضۡ عَنۡهُمۡ وَٱنتَظِرۡ إِنَّهُم مُّنتَظِرُونَ ٣٠\uF05B، وَافْتُتِحَتِ (الأَحْزَابُ) بِالمَوضُوعِ نَفْسِهِ؛ فَقَالَ: \uF05Dيَٰٓأَيُّهَا ٱلنَّبِيُّ ٱتَّقِ ٱللَّهَ وَلَا تُطِعِ ٱلۡكَٰفِرِينَ وَٱلۡمُنَٰفِقِينَۚ …١\uF05B.\n" +
                    "#أكاديمية_إتقان_لتحفيظ_القرآن\n" +
                    "#أكاديمية_إتقان\n" +
                    "#ستحفظ_القرآن_كما_تحفظ_الفاتحة\n" +
                    "#مقاصد_سور_القرآن_الكريم", "https://scontent.fcai22-1.fna.fbcdn.net/v/t39.30808-6/481294674_122112491930732266_9078047651702215806_n.jpg?stp=dst-jpg_p526x296_tt6&_nc_cat=103&ccb=1-7&_nc_sid=127cfc&_nc_eui2=AeGOGTZdLQu8ApHXIwSmdqCUw_P62A3DTNnD8_rYDcNM2bBJU8-odU4XUtjeehR1vb7hCxySTgNll6OOnsKSVR5M&_nc_ohc=q7eehgsh4yIQ7kNvgERpNTC&_nc_oc=Adjmmm6RO2b-Q2zLPHB2PHrrBvIVC1BmMaA1sCO-skJdbbJD5N8t4x9cCbIbGZRH420&_nc_zt=23&_nc_ht=scontent.fcai22-1.fna&_nc_gid=AUwP08KLR_u5aXmfmGiBZUk&oh=00_AYDjX5IMzkNKtAHytSNWtTS57gk3YrwhFk9i5E9Q5EpFwg&oe=67C3F9D0", MediaType.IMAGE),
            Post(1, "Beautiful Landscape", "Nature at its best", "https://scontent.fcai22-1.fna.fbcdn.net/v/t39.30808-6/481294674_122112491930732266_9078047651702215806_n.jpg?stp=dst-jpg_p526x296_tt6&_nc_cat=103&ccb=1-7&_nc_sid=127cfc&_nc_eui2=AeGOGTZdLQu8ApHXIwSmdqCUw_P62A3DTNnD8_rYDcNM2bBJU8-odU4XUtjeehR1vb7hCxySTgNll6OOnsKSVR5M&_nc_ohc=q7eehgsh4yIQ7kNvgERpNTC&_nc_oc=Adjmmm6RO2b-Q2zLPHB2PHrrBvIVC1BmMaA1sCO-skJdbbJD5N8t4x9cCbIbGZRH420&_nc_zt=23&_nc_ht=scontent.fcai22-1.fna&_nc_gid=AUwP08KLR_u5aXmfmGiBZUk&oh=00_AYDjX5IMzkNKtAHytSNWtTS57gk3YrwhFk9i5E9Q5EpFwg&oe=67C3F9D0", MediaType.IMAGE),
            Post(2, "Relaxing Music", "Listen to this soothing track", "https://pixabay.com/music/modern-classical-17-3-2024-bon-choix-de-sa-vie-loin-de-son-ame-soeur-196818/", MediaType.AUDIO),
            Post(3, "Funny Clip", "Check out this hilarious video", "https://fb.watch/x_4vEUw2IR/", MediaType.VIDEO)
        )

        recyclerView.adapter = PostAdapter(posts, object : PostAdapter.OnPostClickListener {
            override fun onPostClick(post: Post) {
                // التعامل مع النقر على العنصر
            }
        })
    }
}
