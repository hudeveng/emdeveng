package com.pridet.ElasticSearch;

import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;
import static org.elasticsearch.index.query.QueryBuilders.termQuery;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.elasticsearch.action.count.CountResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.indices.IndexMissingException;
import org.elasticsearch.script.ScriptService;
import org.elasticsearch.search.SearchHit;

import com.pridet.bo.BaseBO;
import com.pridet.bo.MedicineStoreBO;
import com.pridet.bo.PatientBO;
import com.pridet.bo.SearchBO;
import com.pridet.constant.Type;

public class ElasticSearchUtil {

	private static final String INDEX_NAME = "EasyMed";
	// private static final String TYPE_NAME = "article";
	private List<SearchBO> searchList = new ArrayList<SearchBO>();
	private String tag;

	public ElasticSearchUtil() {
	}

	@SuppressWarnings("unchecked")
	public void prepareDocumentList() {

		ClientProvider.instance().getClient().admin().indices()
				.prepareRefresh().execute().actionGet();
		try {

			SearchResponse response = ClientProvider.instance().getClient()
					.prepareSearch(INDEX_NAME).setTypes(Type.names())
					.setQuery(matchAllQuery()).execute().actionGet();
			SearchBO temporary = null;
			String[] tags = null;

			if (response != null) {
				for (SearchHit hit : response.getHits()) {

					try {

						tags = hit.getSource().get("tags").toString()
								.split(",");
						temporary = new SearchBO();
						temporary.setId(Integer.parseInt(hit.getSource()
								.get("id").toString()));
						temporary.setDbId(Integer.parseInt(hit.getSource()
								.get("DBID").toString()));
						temporary.setDetails((Map<String, Object>) hit
								.getSource().get("details"));
						temporary.setUpdateDate(new SimpleDateFormat(
								"yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale
										.getDefault()).parse(hit.getSource()
								.get("updateDate").toString()));
						temporary.setUpdateDate(new SimpleDateFormat(
								"yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale
										.getDefault()).parse(hit.getSource()
								.get("postDate").toString()));
						temporary.setType(Type.valueOf(hit.getSource()
								.get("type").toString()));
						temporary.setTags(tags);
					} catch (Exception e) {
						e.printStackTrace();
					}
					searchList.add(temporary);
				}
			}

			collectionSort();

		} catch (IndexMissingException ex) {
			System.out.println("IndexMissingException: " + ex.toString());
		}
	}

	public void collectionSort() {

		Collections.sort(searchList, new Comparator<SearchBO>() {

			@Override
			public int compare(SearchBO o1, SearchBO o2) {
				return o2.getName().compareTo(o1.getName());
			}
		});
	}

	@SuppressWarnings("unchecked")
	public List<SearchBO> fullTextSearch(SearchBO searchBO) {

		// articleList.clear();
		// Article temporary = null;
		String[] tags = null;

		try {
			QueryBuilder queryBuilder = QueryBuilders.queryStringQuery("*"
					+ searchBO.getQueryString() + "*");
			SearchRequestBuilder searchRequestBuilder = ClientProvider
					.instance().getClient().prepareSearch(INDEX_NAME);

			searchRequestBuilder.setTypes(com.pridet.constant.Type.names());
			if (null != searchBO && searchBO.getDbId() > 0) {
				searchRequestBuilder.setSearchType(SearchType.fromString(""
						+ searchBO.getDbId()));
			} else {
				searchRequestBuilder.setSearchType(SearchType.DEFAULT);
			}
			searchRequestBuilder.setQuery(queryBuilder);
			searchRequestBuilder.setFrom(0).setSize(60).setExplain(true);

			SearchResponse response = searchRequestBuilder.execute()
					.actionGet();

			if (response != null) {

				for (SearchHit hit : response.getHits()) {
					SearchBO temporary = null;

					try {

						try {

							tags = hit.getSource().get("tags").toString()
									.split(",");
							temporary = new SearchBO();
							temporary.setId(Integer.parseInt(hit.getSource().get("id").toString()));
							temporary
									.setDbId(Integer.parseInt(hit.getSource().get("DBID").toString()));
							temporary.setDetails((Map<String, Object>) hit
									.getSource().get("details"));
							temporary.setUpdateDate(new SimpleDateFormat(
									"yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale
											.getDefault()).parse(hit
									.getSource().get("updateDate").toString()));
							temporary.setUpdateDate(new SimpleDateFormat(
									"yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale
											.getDefault()).parse(hit
									.getSource().get("postDate").toString()));
							temporary.setType(Type.valueOf(hit.getSource()
									.get("type").toString()));
							temporary.setTags(tags);
						} catch (Exception e) {
							e.printStackTrace();
						}
						searchList.add(temporary);
					} catch (Exception e) {
						e.printStackTrace();
					}
					searchList.add(temporary);
				}
			}

			collectionSort();

		} catch (IndexMissingException ex) {
			System.out.println("IndexMissingException: " + ex.toString());
		}
		return searchList;
	}

	public static Map<String, Object> putJsonDocument(Long ID, String type,
			String name, int id, Map<String, Object> details, String postDate,
			String updateDdate, String[] postTags) {

		Map<String, Object> jsonDocument = new HashMap<String, Object>();

		try {
			SimpleDateFormat sdf = new SimpleDateFormat(
					"yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
			String formattedPostDate = sdf.format(postDate);

			jsonDocument.put("id", ID);
			jsonDocument.put("type", type);
			jsonDocument.put("DBID", id);
			jsonDocument.put("details", details);
			jsonDocument.put("name", name);
			jsonDocument.put("postDate", postDate);
			jsonDocument.put("updateDate", updateDdate);
			jsonDocument.put("tags", postTags);
		} catch (Exception ex) {
			// FacesContext.getCurrentInstance().addMessage(
			// null,
			// new FacesMessage(FacesMessage.SEVERITY_ERROR,
			// "Sorry, an error has occurred", ex.toString()));
		}

		return jsonDocument;
	}

	public void saveDetails(BaseBO baseBO) {

		Long ID = 1l;
		SearchBO searchBo = fullTextSearch(getSearchBO(baseBO)).get(0);
		SimpleDateFormat sdf = new SimpleDateFormat(
				"yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		String currentDate = sdf.format(new Date());

		try {

			CountResponse countResponse = ClientProvider
					.instance()
					.getClient()
					.prepareCount(INDEX_NAME)
					.setQuery(
							termQuery("_type", searchBo.getType()
									.getServicename())).execute().actionGet();
			ID += countResponse.getCount();

		} catch (IndexMissingException ex) {
			System.out.println("IndexMissingException: " + ex.toString());
		}

		String[] postTags = tag.split(",");

		try {

			if (searchBo.getDbId() > 0)
				ClientProvider
						.instance()
						.getClient()
						.prepareIndex(searchBo.getType().getServicename(),
								searchBo.getName(), ID.toString())
						.setSource(
								putJsonDocument(ID, searchBo.getType()
										.getServicename(), searchBo.getName(),
										searchBo.getDbId(), searchBo
												.getDetails(), currentDate,
										currentDate, searchBo.getTags()))
						.execute().actionGet();
			else {
				Map<String, Object> updateObject = new HashMap<String, Object>();

				updateObject.put("type", searchBo.getType().getServicename());
				updateObject.put("id", searchBo.getId());
				updateObject.put("name", searchBo.getName());
				updateObject.put("updateDate", currentDate);
				updateObject.put("details", searchBo.getDetails());
				updateObject.put("tags", searchBo.getTags());

				ClientProvider
						.instance()
						.getClient()
						.prepareUpdate(INDEX_NAME,
								searchBo.getType().getServicename(),
								"" + searchBo.getId())
						.setScript(
								"ctx._source.type=type; ctx._source.name=name; "
										+ "ctx._source.updateDate=updateDate; ctx._source.details=details; "
										+ "ctx._source.tags=tags",
								ScriptService.ScriptType.INLINE)
						.setScriptParams(updateObject).execute().actionGet();
			}

		} catch (Exception ex) {
		}

		prepareDocumentList();
		// initArticle();

	}

	private SearchBO getSearchBO(BaseBO baseBO) {
		SearchBO searchBO = new SearchBO();
		List<String> tags = new ArrayList<String>();
		String[] postTags = {};
		if (baseBO instanceof MedicineStoreBO) {
			MedicineStoreBO msdo = new MedicineStoreBO();
			searchBO.setId(msdo.getId());
			searchBO.setName(msdo.getStorename());
			tags.add(msdo.getStorename());
			Map<String, Object> detailsMap = new HashMap<String, Object>();
			detailsMap.put("LicenseNo", msdo.getLicennceno());
			tags.add(msdo.getLicennceno());
			searchBO.setDetails(detailsMap);
			searchBO.setType(Type.MEDICALSTORES);
		} else if (baseBO instanceof PatientBO) {

			PatientBO ptDO = new PatientBO();
			searchBO.setId(ptDO.getId());
			searchBO.setName(ptDO.getFirstname() + " " + ptDO.getLastname());
			tags.add(searchBO.getName());
			Map<String, Object> detailsMap = new HashMap<String, Object>();
			detailsMap.put("email", ptDO.getEmail());
			tags.add(ptDO.getEmail());
			searchBO.setDetails(detailsMap);
			searchBO.setType(Type.PATIENT);
		}
		String[] tagsArray = new String[tags.size()];
		searchBO.setTags(tags.toArray(tagsArray));
		return searchBO;
	}

	public void removeArticle(SearchBO searchBO) {

		try {
			ClientProvider
					.instance()
					.getClient()
					.prepareDelete(INDEX_NAME,
							searchBO.getType().getServicename(),
							"" + searchBO.getId()).execute().actionGet();
		} catch (Exception ex) {
		}

		prepareDocumentList();
	}

	public static void main(String[] args) {
	}

}
